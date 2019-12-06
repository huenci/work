package com.jiabiango.hr.wechat.entity.message.template;

import java.util.Iterator;
import java.util.List;

/**
 * @describe 推送模版消息
 * @author lukas Lukas 414024003@qq.com
 * @date 2016年8月13日 10:56:14
 * @version 1.0
 */
public class TemplateMessage {
	public static final String TEMPLATE_SEND = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";

	/**
	 * 推送模版消息
	 * 
	 * @param openid
	 *            微信用户标识
	 * @param template_id
	 *            自定义模版标识
	 * @param url
	 *            推送消息详情地址
	 * @param topcolor
	 *            模版消息头部颜色
	 * @param templates
	 *            模版内容
	 * @return
	 * @throws Exception
	 */
	public static String sendTemplateMessage(String openid, String template_id, String url, String topcolor,
			List<Template> templates) {
		if ((templates == null) || (templates.size() <= 0)) {
			return "";
		}

		StringBuffer buffer = new StringBuffer();
		for (Iterator localIterator = templates.iterator(); localIterator.hasNext();) {
			Template template = (Template) localIterator.next();
			buffer.append("\"" + template.getKey() + "\":{\"value\":\"" + template.getValue() + "\",\"color\":\""
					+ template.getColor() + "\"},");
		}

		String str = "{\"touser\":\"" + openid + "\",\"template_id\":\"" + template_id + "\",\"url\":\"" + url
				+ "\",\"topcolor\":\"" + topcolor + "\",\"data\":{" + buffer.substring(0, buffer.length() - 1) + "}}";
		System.out.println(str);
		return str;
	}

	
	/**
	 * 公众号发送消息模板
	 * @param openid
	 * @param template_id
	 * @param url
	 * @param topcolor
	 * @param templates
	 * @param appid
	 * @param pagepath
	 * @return
	 */
	public static String sendTemplateMessageMiNi(String openid, String template_id, String url, String topcolor,
			List<Template> templates,String appid,String pagepath) {
		if ((templates == null) || (templates.size() <= 0)) {
			return "";
		}

		StringBuffer buffer = new StringBuffer();
		for (Iterator localIterator = templates.iterator(); localIterator.hasNext();) {
			Template template = (Template) localIterator.next();
			buffer.append("\"" + template.getKey() + "\":{\"value\":\"" + template.getValue() + "\",\"color\":\""
					+ template.getColor() + "\"},");
		}
		String str = "{\"touser\":\"" + openid + "\",\"template_id\":\"" + template_id + "\",\"url\":\"" + url
				+ "\",\"miniprogram\":{\"appid\":\""+appid+"\",\"pagepath\":\""+pagepath+"\"},\"topcolor\":\"" + topcolor
				+ "\",\"data\":{" + buffer.substring(0, buffer.length() - 1) + "}}";
		System.out.println(str);
		return str;
	}
	
	
	/**
	 * 小程序推送模版消息
	 * 
	 * @param openid
	 *            微信用户标识
	 * @param template_id
	 *            自定义模版标识
	 * @param url
	 *            推送消息详情地址
	 * @param topcolor
	 *            模版消息头部颜色
	 * @param templates
	 *            模版内容
	 *  form_id 提交ID
	 * @return
	 * @throws Exception
	 */
	public static String sendSmallTemplateMessage(String openid, String template_id, String url, String topcolor,
			List<Template> templates,String pagepath,String form_id) {
		if ((templates == null) || (templates.size() <= 0)) {
			return "";
		}

		StringBuffer buffer = new StringBuffer();
		for (Iterator localIterator = templates.iterator(); localIterator.hasNext();) {
			Template template = (Template) localIterator.next();
			buffer.append("\"" + template.getKey() + "\":{\"value\":\"" + template.getValue() + "\",\"color\":\""
					+ template.getColor() + "\"},");
		}

		String str = "{\"touser\":\"" + openid + "\",\"template_id\":\"" + template_id + "\",\"url\":\"" + url+ "\",\"form_id\":\"" + form_id
				+ "\",\"page\":\"" + pagepath
				+ "\",\"topcolor\":\"" + topcolor + "\",\"data\":{" + buffer.substring(0, buffer.length() - 1) + "}}";
		System.out.println(str);
		return str;
	}

	/**
	 * 封装模版消息
	 * 
	 * @param templates
	 *            模版对象
	 * @param color
	 *            颜色
	 * @param key
	 *            键
	 * @param Value
	 *            值
	 * @return
	 */
	public static List<Template> setTemplate(List<Template> templates, String color, String key, String Value) {
		Template t = new Template();
		t.setColor(color);
		t.setKey(key);
		t.setValue(Value);
		templates.add(t);
		return templates;
	}

}