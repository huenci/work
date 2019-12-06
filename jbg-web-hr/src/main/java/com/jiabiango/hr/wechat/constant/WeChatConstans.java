package com.jiabiango.hr.wechat.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WeChatConstans {
	
	/**
	 * 微信商户号
	 */
	public static String mch_id;

	/**
	 * 微信商户号key
	 */
	public static String partner_key;
	/**
	 * 自定义当前公众号令牌
	 */
	public static String token;

	/**
	 * 当前公众号标识
	 */
	public static String appId;
	/**
	 * 当前公众号秘钥
	 */
	public static String appSecret;
	
	/**
	 * 当前小程序标识
	 */
	public static String appMiniId;

	/**
	 * 当前小程序秘钥
	 */
	public static String appMiniSecret;
	
	/**
	 * 微信支付回调域名
	 */
	public static String payUrl;
	
	/**
	 * 中台会员接口地址
	 */
	public static String memberCenterUrl;
	
	/**
	 * 账户活动余额提醒模板消息标识
	 */
	public static String templateIdOne;
	
	/**
	 * 积分提醒模板消息标识
	 */
	public static String templateIdTwo;
	
	
	/**
	 * 消费成功通知提醒模板消息标识
	 */
	public static String templateIdThree;
	
	/**
	 * 充值成功通知模板消息标识
	 */
	public static String templateIdFour;
	/**
	 * 订单评价通知模板消息标识
	 */
	public static String templateIdFive;
	
	/**
	 * 账户正常余额提醒模板消息标识
	 */
	public static String templateIdSix;
	
	@Value("${wechat.templateIdSix:fhxEvMgAm8FNEORKTWtHBogeyiu87xmLxM8Ykx0TE6k}")
	public  void setTemplateIdSix(String templateIdSix) {
		WeChatConstans.templateIdSix = templateIdSix;
	}
	
	@Value("${wechat.templateIdFive:ZlhzzcIcteZII-iVM6o-JC6zpAC2m8fgt4lHUgl58z4}")
	public  void setTemplateIdFive(String templateIdFive) {
		WeChatConstans.templateIdFive = templateIdFive;
	}
	
	
	@Value("${wechat.templateIdOne:fhxEvMgAm8FNEORKTWtHBrxgzBm4zHSAr7hVvVFpSvY}")
	public  void setTemplateIdOne(String templateIdOne) {
		WeChatConstans.templateIdOne = templateIdOne;
	}
	
	@Value("${wechat.templateIdTwo:ezBKkqGaoGy68YJsNTDqws_gkw2zpLBh01eLnDBIai8}")
	public  void setTemplateIdTwo(String templateIdTwo) {
		WeChatConstans.templateIdTwo = templateIdTwo;
	}
	
	
	@Value("${wechat.templateIdThree:Uv4HVQcTEw3F92K-q0DjexrTk0dL5rVOzn8x_ouvw-4}")
	public  void setTemplateIdThree(String templateIdThree) {
		WeChatConstans.templateIdThree = templateIdThree;
	}
	
	@Value("${wechat.templateIdFour:6MPXEBmk3wTND7FHlIsTw8GIjVjXgv5tEOZYUlQNTzc}")
	public  void setTemplateIdFour(String templateIdFour) {
		WeChatConstans.templateIdFour = templateIdFour;
	}
	

	@Value("${member.memberCenterUrl:http://118.31.78.106:8001/members-service/members/syn}")
	public void setMemberCenterUrl(String memberCenterUrl) {
		WeChatConstans.memberCenterUrl = memberCenterUrl;
	}

	@Value("${wechat.payUrl:https://yx.jiabiango.com/api/memcentral/WeiXin/}")
	public  void setPayUrl(String payUrl) {
		WeChatConstans.payUrl = payUrl;
	}

	@Value("${xcx_dzhy_appId2:wx5031e88c2a41ab54}")
	public  void setAppMiniId(String appMiniId) {
		WeChatConstans.appMiniId = appMiniId;
	}

	@Value("${xcx_dzhy_appSecret2:41dca675f077e4a9b37ce09ade016c0e}")
	public  void setAppMiniSecret(String appMiniSecret) {
		WeChatConstans.appMiniSecret = appMiniSecret;
	}

	@Value("${wechat.mchId:1514631091}")
	public  void setMch_id(String mchId) {
		WeChatConstans.mch_id = mchId;
	}

	@Value("${wechat.partnerKey:Dianzihuiyuan2018JBGcptbtptp2017}")
	public  void setPartner_key(String partnerKey) {
		WeChatConstans.partner_key = partnerKey;
	}

	@Value("${wechat.toKen:jbg_test_20171205}")
	public  void setToken(String toKen) {
		WeChatConstans.token = toKen;
	}

	@Value("${jbg_bld_appId:wxccfdceb5c18ea205}")
	public  void setAppId(String appid) {
		WeChatConstans.appId = appid;
	}

	@Value("${jbg_bld_appSecret:63c619263efa769ac4638804fcce4b94}")
	public  void setAppSecret(String appsecret) {
		WeChatConstans.appSecret = appsecret;
	}


	static final String APIURL = "https://api.weixin.qq.com/cgi-bin/";
	static final String MEDIAURL = "http://file.api.weixin.qq.com/cgi-bin/media/";
	private static final String UPLOADFILE = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=";
	private static final String DOWNLOADFILE = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=";
	private static final String QRCODE_CREATE = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=";
	private static final String QRCODE_SHOW = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=";
	public static final String UPLOAD_TYPE_IMAGE = "image";
	public static final String UPLOAD_TYPE_VOICE = "voice";
	public static final String UPLOAD_TYPE_VIDEO = "video";
	public static final String UPLOAD_TYPE_THUMB = "thumb";
	
	/**
	 * 微信AccessToken键
	 */
	public static final String ACCESS_TOKEN = "AccessToken";
	
	/**
	 * 微信授权AccessToken键
	 */
	public static final String OAUTH_ACCESS_TOKEN = "OauthAccessToken";
	
	/**
	 * 微信小程序AccessToken键
	 */
	public static final String MINI_ACCESS_TOKEN = "MiniAccessToken";
	
	
	/**
	 * 微信AccessToken键
	 */
	public static final String TICKET = "ticket";

}
