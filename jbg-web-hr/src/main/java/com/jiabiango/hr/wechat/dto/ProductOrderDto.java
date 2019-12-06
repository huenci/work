package com.jiabiango.hr.wechat.dto;

public class ProductOrderDto {
	/**
	 * 微信标识
	 */
	private String openId;
	
	/**
	 * 支付类型
	 */
	private String payType;

	/**
	 * 充值金额
	 */
	private Double totalPrice;
	
	/**
	 * 电话号码
	 */
	private String phoneNumber;
	
	/**
	 * 小程序OPENid
	 */
	private String miOpenId;
	
	/**
	 * 商品Id
	 */
	private Integer productId;

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMiOpenId() {
		return miOpenId;
	}

	public void setMiOpenId(String miOpenId) {
		this.miOpenId = miOpenId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
}
