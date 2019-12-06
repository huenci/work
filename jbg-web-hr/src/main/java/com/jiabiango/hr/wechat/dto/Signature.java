package com.jiabiango.hr.wechat.dto;

/**
 * @category说明：微信通用签名
 * @author创建人：lukas
 * @date创建时间：2017年12月26日17:01:07
 * @emial邮箱：414024003@163.com
 */
public class Signature {
	
	/**
	 * 时间戳
	 */
	private String timeStamp;
	
	/**
	 * 随机字符串
	 */
	private String nonceStr;

	
	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	
	
	

}
