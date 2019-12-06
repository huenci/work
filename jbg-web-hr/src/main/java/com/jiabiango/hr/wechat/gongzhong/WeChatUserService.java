package com.jiabiango.hr.wechat.gongzhong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jiabiango.hr.wechat.gongzhong.util.GongZhongUtils;
import com.jiabiango.hr.wechat.gongzhong.vo.user.UserInfo;
import com.jiabiango.hr.wechat.gongzhong.vo.user.UserList;

/**
 * @describe 微信用户管理
 * @author lukas Lukas 414024003@qq.com
 * @date 2016年8月13日 10:56:14
 * @version 1.0
 */
@Component
public class WeChatUserService {
	@Autowired
	private GongZhongService gongZhongService;
	private static Logger logger = LoggerFactory.getLogger(WeChatUserService.class);
	private static final String USER_GET = "https://api.weixin.qq.com/cgi-bin/user/get?";
	private static final String USER_INFO = "https://api.weixin.qq.com/cgi-bin/user/info?";
	private static final String USER_INFO_UPDATEREMARK = "https://api.weixin.qq.com/cgi-bin/user/info/updateremark?";
	private static final String GROUPS_MEMBERS_UPDATE = "https://api.weixin.qq.com/cgi-bin/groups/members/update?";

	/**
	 * 通过微信用户开始标识获取微信用户列表
	 * 
	 * @param startOpenId
	 *            微信用户开始标识
	 * @return
	 * @throws Exception
	 */
	public UserList getUser(String startOpenId) throws Exception {
		String reslut = GongZhongUtils.sendPost("https://api.weixin.qq.com/cgi-bin/user/get?",
				"access_token=" + gongZhongService.getAccessToken() + "&next_openid=" + startOpenId);

		JSONObject obj = (JSONObject) JSON.parseObject(reslut).get("data");
		UserList userList = new UserList();
		userList.setTotal(JSON.parseObject(reslut).getInteger("total"));
		userList.setCount(JSON.parseObject(reslut).getInteger("count"));
		userList.setNextOpenid(JSON.parseObject(reslut).getString("next_openid"));
		userList.setOpenIdList(JSON.parseArray(obj.getString("openid"), String.class));
		return userList;
	}
	
	
	public UserList getUserMini(String startOpenId) throws Exception {
		String reslut = GongZhongUtils.sendPost("https://api.weixin.qq.com/cgi-bin/user/get?",
				"access_token=" + gongZhongService.getAccessTokenByMini() + "&next_openid=" + startOpenId);

		JSONObject obj = (JSONObject) JSON.parseObject(reslut).get("data");
		UserList userList = new UserList();
		userList.setTotal(obj.getInteger("total"));
		userList.setCount(obj.getInteger("count"));
		userList.setNextOpenid(obj.getString("next_openid"));
		userList.setOpenIdList(JSON.parseArray(obj.getString("openid"), String.class));
		return userList;
	}
	
	
	/**
	 * 批量获取微信公众号用户信息
	 * @return
	 * @throws Exception
	 */
	public String batchGetUser() throws Exception {
		String reslut = GongZhongUtils.sendPost("https://api.weixin.qq.com/cgi-bin/user/info/batchget?","access_token=" + gongZhongService.getAccessToken());
		return reslut;
	}

	/**
	 * 通过微信用户标识获取用户基本信息
	 * 
	 * @param openId
	 * @return
	 * @throws Exception
	 */
	public UserInfo getUserInfo(String openId) {
		String reslut = "";
		UserInfo u = new UserInfo();
		try {
			reslut = GongZhongUtils.sendPost("https://api.weixin.qq.com/cgi-bin/user/info?",
					"access_token=" + gongZhongService.getAccessToken() + "&openid=" + openId);
		} catch (Exception e) {
			logger.info("getUserInfo-----------------------openId:" + openId + "---->" + e.toString());
			e.printStackTrace();
		}
		JSONObject obj = JSON.parseObject(reslut);
		u.setCity(obj.getString("city"));
		u.setCountry(obj.getString("country"));
		u.setGroupid(obj.getString("groupid"));
		u.setHeadimgurl(obj.getString("headimgurl"));
		u.setLanguage(obj.getString("language"));
		u.setNickname(obj.getString("nickname"));
		u.setOpenid(obj.getString("openid"));
		u.setProvince(obj.getString("province"));
		u.setRemark(obj.getString("remark"));
		u.setSex(obj.getString("sex"));
		u.setSubscribe(obj.getString("subscribe"));
		u.setSubscribe_time(obj.getString("subscribe_time"));
		u.setUnionId(obj.getString("unionid"));
		return u;
	}

	
	public UserInfo getUserInfoMi(String openId) {
		String reslut = "";
		try {
			reslut = GongZhongUtils.sendPost("https://api.weixin.qq.com/cgi-bin/user/info?",
					"access_token=" + gongZhongService.getAccessTokenByMini() + "&openid=" + openId);
		} catch (Exception e) {
			logger.info("getUserInfo-----------------------openId:" + openId + "---->" + e.toString());
			e.printStackTrace();
		}
		
		return JSON.parseObject(reslut, UserInfo.class);
	}
	/**
	 * 通过微信用户标识以及群组标识修改微信用户群组
	 * 
	 * @param openid
	 *            微信用户标识
	 * @param groupId
	 *            修改为群组标识
	 * @throws Exception
	 */
	public void moveUserGroup(String openid, int groupId) throws Exception {
		GongZhongUtils.sendPost(
				"https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token="
						+ gongZhongService.getAccessToken(),
				"{\"openid\":\"" + openid + "\",\"to_groupid\":" + groupId + "}");
	}

	/**
	 * 通过微信用户标识修改用户备注
	 * 
	 * @param openid
	 *            微信用户标识
	 * @param remark
	 *            备注
	 * @throws Exception
	 */
	public void updateRemark(String openid, String remark) throws Exception {
		GongZhongUtils.sendPost(
				"https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token="
						+ gongZhongService.getAccessToken(),
				"{\"openid\":\"" + openid + "\",\"remark\":\"" + remark + "\"}");
	}
}
