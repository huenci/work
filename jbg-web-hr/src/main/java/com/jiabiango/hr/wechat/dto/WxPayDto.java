package com.jiabiango.hr.wechat.dto;


public class WxPayDto {

	/**
	 * 支付订单号
	 */
	private String orderId;
	
	/**
	 * 支付订单金额
	 */
	private String totalFee;
	
	/**
	 * 发起支付IP
	 */
	private String spbillCreateIp;
	
	/**
	 * 微信支付成功后回调服务器接口地址
	 */
	private String notifyUrl;
	
	/**
	 * 订单内容描述
	 */
	private String body;
	
	/**
	 * 当前支付订单微信用户标识
	 */
	private String openId;
	
	/**
	 * 支付类型默认为1，1:购买商品支付订单，2:会员余额充值订单
	 */
	private String payType;
	
	/**
	 * @return the orderId
	 */
	public String getPayType() {
		return payType;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}
	
	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the totalFee
	 */
	public String getTotalFee() {
		return totalFee;
	}
	/**
	 * @param totalFee the totalFee to set
	 */
	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}
	/**
	 * @return the spbillCreateIp
	 */
	public String getSpbillCreateIp() {
		return spbillCreateIp;
	}
	/**
	 * @param spbillCreateIp the spbillCreateIp to set
	 */
	public void setSpbillCreateIp(String spbillCreateIp) {
		this.spbillCreateIp = spbillCreateIp;
	}
	/**
	 * @return the notifyUrl
	 */
	public String getNotifyUrl() {
		return notifyUrl;
	}
	/**
	 * @param notifyUrl the notifyUrl to set
	 */
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}
	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}
	/**
	 * @return the openId
	 */
	public String getOpenId() {
		return openId;
	}
	/**
	 * @param openId the openId to set
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	@Override
	public String toString() {
		return "WxPayDto [orderId=" + orderId + ", totalFee=" + totalFee + ", spbillCreateIp=" + spbillCreateIp
				+ ", notifyUrl=" + notifyUrl + ", body=" + body + ", openId=" + openId + ", payType=" + payType + "]";
	}
	
	
	
}
