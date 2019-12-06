package com.jiabiango.hr.wechat.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiabiango.hr.util.HttpUtil;
import com.jiabiango.hr.wechat.constant.WeChatConstans;
import com.jiabiango.hr.wechat.entity.message.template.Template;
import com.jiabiango.hr.wechat.entity.message.template.TemplateMessage;
import com.jiabiango.hr.wechat.gongzhong.GongZhongService;

/**
 * @describe 模板推送实现类
 * @author hnbin1987@163.com
 */
@Service
public class TemplateService {

	/*private static Logger logger = LoggerFactory.getLogger(TemplateService.class);
	// 积分界面
	private static String integralPagepath = "pages/integral/record/record";
	//余额界面
	private static String balancPagepath = "pages/index/index?jumpRecharge=true";
	//首页界面
	private static String indexPagepath = "pages/index/index";
	

	@Autowired
	private GongZhongService gongZhongService;
	@Autowired
	private MemberMapper memberMapper;

	private List<Template> loadTemplateList(Map<String, String> pd) {
		String color = "#173177";
		String key = "";
		String Value = "";
		List<Template> t = new ArrayList<Template>();
		for (Map.Entry<String, String> entry : pd.entrySet()) {
			key = entry.getKey();
			Value = entry.getValue();
			t = TemplateMessage.setTemplate(t, color, key, Value);
		}
		return t;
	}

	*//**
	 * 账户余额提醒小程序模板消息
	 * 
	 * @param smallOpenId
	 *            小程序用户openId
	 * @param formId
	 *            小程序form_Id,1个form_id过期为7天
	 *//*
	public void sendBalanceNotice(Map<String, String> map) {
		try{
			// 查询smallOpenId对应的formId
			String smallOpneId = map.get("smallOpenId");
			String formId = memberMapper.queryFormId(smallOpneId);
			if (formId == null) {
				return;
			}
			// 链接地址
			String url = "https://yx.jiabiango.com/index.html?STOREID=";
			// 颜色
			String topcolor = "#8EC31F";
			Map<String, String> m = new HashMap<String, String>();
			// 变动金额
			m.put("keyword1", map.get("amount"));
			// 变动类型
			m.put("keyword2", map.get("typeName"));
			// 变动原因
			m.put("keyword3",  map.get("reason"));
			// 变动时间
			m.put("keyword4", new SimpleDateFormat("yyyy年MM月dd日 HH:mm ").format(new Date()));
			List<Template> t = loadTemplateList(m);
			logger.info("show PageData m: " + m);
			logger.info("show List<Template> t: " + t);

			String str = TemplateMessage.sendSmallTemplateMessage(smallOpneId, WeChatConstans.templateIdOne, url,
					topcolor, t, balancPagepath, formId);
			HttpUtil.sendPostUrl("https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token="
					+ gongZhongService.getAccessTokenByMini(), str, "UTF-8");

			// 删除小程序openId对应使用后的formId
			memberMapper.deleteFormId(smallOpneId);
		}catch(Exception e){
			e.printStackTrace();
			logger.error("sendBalanceNotice error="+e.getMessage());
		}
	}

	*//**
	 * 积分变动提醒小程序模板消息
	 * 
	 * @param smallOpenId
	 *            小程序用户openId
	 * @param formId
	 *            小程序form_Id,1个form_id过期为7天
	 *//*
	public void sendIntegralNotice(Map<String, String> map) {
		try{
			// 查询smallOpenId对应的formId
			String smallOpneId = map.get("smallOpenId");
			String formId = memberMapper.queryFormId(smallOpneId);
			if (formId == null) {
				return;
			}
			// 链接地址
			String url = "https://yx.jiabiango.com/index.html?STOREID=";
			// 颜色
			String topcolor = "#8EC31F";
			Map<String, String> m = new HashMap<String, String>();
			// 对应手机号
			m.put("keyword1", map.get("phoneNumber"));
			// 可用积分
			m.put("keyword2", map.get("integral"));
			// 获得原因
			m.put("keyword3", map.get("reason"));
			// 发送日期
			m.put("keyword4", new SimpleDateFormat("yyyy年MM月dd日 HH:mm ").format(new Date()));
			List<Template> t = loadTemplateList(m);
			logger.info("show PageData m: " + m);
			logger.info("show List<Template> t: " + t);

			String str = TemplateMessage.sendSmallTemplateMessage(smallOpneId, WeChatConstans.templateIdTwo, url,
					topcolor, t, integralPagepath, formId);
			HttpUtil.sendPostUrl("https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token="
					+ gongZhongService.getAccessTokenByMini(), str, "UTF-8");

			// 删除小程序openId对应使用后的formId
			memberMapper.deleteFormId(smallOpneId);
		}catch(Exception e){
			e.printStackTrace();
			logger.error("sendIntegralNotice error="+e.getMessage());
		}
	}
	
	
	*//**
	 * 消费成功通知小程序模板消息
	 * 
	 * @param smallOpenId
	 *            小程序用户openId
	 * @param formId
	 *            小程序form_Id,1个form_id过期为7天
	 *//*
	public void sendConsumptiveNotice(Map<String, String> map) {
		try{
			// 查询smallOpenId对应的formId
			String smallOpneId = map.get("smallOpenId");
			String formId = memberMapper.queryFormId(smallOpneId);
			if (formId == null) {
				return;
			}
			// 链接地址
			String url = "https://yx.jiabiango.com/index.html?STOREID=";
			// 颜色
			String topcolor = "#8EC31F";
			Map<String, String> m = new HashMap<String, String>();
			// 支付方式
			m.put("keyword1", map.get("typeName"));
			// 消费金额
			m.put("keyword2", map.get("amount"));
			// 订单号
			m.put("keyword3",  map.get("billNo"));
			// 消费时间
			m.put("keyword4", new SimpleDateFormat("yyyy年MM月dd日 HH:mm ").format(new Date()));
			List<Template> t = loadTemplateList(m);
			logger.info("show PageData m: " + m);
			logger.info("show List<Template> t: " + t);

			String str = TemplateMessage.sendSmallTemplateMessage(smallOpneId, WeChatConstans.templateIdThree, url,
					topcolor, t, integralPagepath, formId);
			HttpUtil.sendPostUrl("https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token="
					+ gongZhongService.getAccessTokenByMini(), str, "UTF-8");

			// 删除小程序openId对应使用后的formId
			memberMapper.deleteFormId(smallOpneId);
		}catch(Exception e){
			e.printStackTrace();
			logger.error("sendBalanceNotice error="+e.getMessage());
		}
	}
	
	
	*//**
	 * 充值成功通知小程序模板消息
	 * 
	 * @param smallOpenId
	 *            小程序用户openId
	 * @param formId
	 *            小程序form_Id,1个form_id过期为7天
	 *//*
	public void sendRechargeNotice(Map<String, String> map) {
		try{
			// 查询smallOpenId对应的formId
			String smallOpneId = map.get("smallOpenId");
			String formId = memberMapper.queryFormId(smallOpneId);
			if (formId == null) {
				return;
			}
			// 链接地址
			String url = "https://yx.jiabiango.com/index.html?STOREID=";
			// 颜色
			String topcolor = "#8EC31F";
			Map<String, String> m = new HashMap<String, String>();
			// 充值金额
			m.put("keyword1", map.get("amount"));
			// 赠送金额
			m.put("keyword2", map.get("donationAmount"));
			// 到账金额
			m.put("keyword3",  map.get("accountAmount"));
			// 充值类型
			m.put("keyword4",  map.get("typeName"));
			// 充值时间
			m.put("keyword5", new SimpleDateFormat("yyyy年MM月dd日 HH:mm ").format(new Date()));
			List<Template> t = loadTemplateList(m);
			logger.info("show PageData m: " + m);
			logger.info("show List<Template> t: " + t);

			String str = TemplateMessage.sendSmallTemplateMessage(smallOpneId, WeChatConstans.templateIdFour, url,
					topcolor, t, balancPagepath, formId);
			HttpUtil.sendPostUrl("https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token="
					+ gongZhongService.getAccessTokenByMini(), str, "UTF-8");

			// 删除小程序openId对应使用后的formId
			memberMapper.deleteFormId(smallOpneId);
		}catch(Exception e){
			e.printStackTrace();
			logger.error("sendBalanceNotice error="+e.getMessage());
		}
	}
	
	*//**
	 * 订单评价通知小程序模板消息
	 * 
	 * @param map
	 *            小程序用户openId
	 * @param map
	 *            小程序form_Id,1个form_id过期为7天
	 *//*
	public void sendEvaluateNotice(Map<String, String> map) {
		try{
			// 查询smallOpenId对应的formId
			String smallOpneId = map.get("smallOpenId");
			String formId = memberMapper.queryFormId(smallOpneId);
			if (formId == null) {
				return;
			}
			// 链接地址
			String url = "https://yx.jiabiango.com/index.html?STOREID=";
			// 颜色
			String topcolor = "#8EC31F";
			Map<String, String> m = new HashMap<String, String>();
			// 门店名称
			m.put("keyword1", map.get("storeName"));
			// 温馨提示
			m.put("keyword2", map.get("reason"));
			List<Template> t = loadTemplateList(m);
			logger.info("show PageData m: " + m);
			logger.info("show List<Template> t: " + t);

			String str = TemplateMessage.sendSmallTemplateMessage(smallOpneId, WeChatConstans.templateIdFive, url,
					topcolor, t, indexPagepath, formId);
			HttpUtil.sendPostUrl("https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token="
					+ gongZhongService.getAccessTokenByMini(), str, "UTF-8");

			// 删除小程序openId对应使用后的formId
			memberMapper.deleteFormId(smallOpneId);
		}catch(Exception e){
			e.printStackTrace();
			logger.error("sendBalanceNotice error="+e.getMessage());
		}
	}
	
	*//**
	 * 账户正常余额提醒小程序模板消息
	 * 
	 * @param map
	 *            小程序用户openId
	 * @param map
	 *            小程序form_Id,1个form_id过期为7天
	 *//*
	public void sendNormalBalanceNotice(Map<String, String> map) {
		try{
			// 查询smallOpenId对应的formId
			String smallOpneId = map.get("smallOpenId");
			String formId = memberMapper.queryFormId(smallOpneId);
			if (formId == null) {
				return;
			}
			// 链接地址
			String url = "https://yx.jiabiango.com/index.html?STOREID=";
			// 颜色
			String topcolor = "#8EC31F";
			Map<String, String> m = new HashMap<String, String>();
			// 商户名称
			m.put("keyword1", "家边购便利店");
			// 变动金额
			m.put("keyword2", map.get("amount"));
			// 变动类型
			m.put("keyword3", map.get("typeName"));
			// 账户余额
			m.put("keyword4", map.get("balance"));
			// 变动时间
			m.put("keyword5", new SimpleDateFormat("yyyy年MM月dd日 HH:mm ").format(new Date()));
			List<Template> t = loadTemplateList(m);
			logger.info("show PageData m: " + m);
			logger.info("show List<Template> t: " + t);

			String str = TemplateMessage.sendSmallTemplateMessage(smallOpneId, WeChatConstans.templateIdSix, url,
					topcolor, t, balancPagepath, formId);
			HttpUtil.sendPostUrl("https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token="
					+ gongZhongService.getAccessTokenByMini(), str, "UTF-8");

			// 删除小程序openId对应使用后的formId
			memberMapper.deleteFormId(smallOpneId);
		}catch(Exception e){
			e.printStackTrace();
			logger.error("sendBalanceNotice error="+e.getMessage());
		}
	}*/
}
