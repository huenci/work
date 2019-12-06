package com.jiabiango.hr.model.customer;

import java.util.Date;

import com.jiabiango.hr.model.hobbies.HobbiesDetails;

public class Customer {
	/**
	 * ID
	 */
	private Integer id;
	
	/**
	 * 用户主键
	 */
	private String customerId;
	
	/**
	 * 微信标识
	 */
	private String openId;
	
	/**
	 * 手机号码
	 */
	private String phoneNumber;
	
	/**
	 * 姓名
	 */
	private String customerName;
	
	/**
	 * 微信昵称
	 */
	private String wechatName;
	
	/**
	 * 性别
	 */
	private Integer sex;
	
	/**
	 * 头像地址
	 */
	private String headImgUrl;
	
	/**
	 * 省
	 */
	private String province;
	
	/**
	 * 市
	 */
	private String city;
	
	/**
	 * 区
	 */
	private String country;
	
	/**
	 * 创建时间
	 */
	private Date createDate;
	
	/**
	 * 修改时间
	 */
	private Date editDate;

	private String[] ids;
	
	private String custhobbies;
	
	public String getCusthobbies() {
		return custhobbies;
	}

	public void setCusthobbies(String custhobbies) {
		this.custhobbies = custhobbies;
	}

	private HobbiesDetails hobbiesDetails;
	
	public HobbiesDetails getHobbiesDetails() {
		return hobbiesDetails;
	}

	public void setHobbiesDetails(HobbiesDetails hobbiesDetails) {
		this.hobbiesDetails = hobbiesDetails;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getWechatName() {
		return wechatName;
	}

	public void setWechatName(String wechatName) {
		this.wechatName = wechatName;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getHeadImgUrl() {
		return headImgUrl;
	}

	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getEditDate() {
		return editDate;
	}

	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}
	
}
