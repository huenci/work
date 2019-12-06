package com.jiabiango.hr.model.hobbies;

import java.util.Date;

public class HobbiesDetails {
	/**
	 * 主键
	 */
	private Integer id;
	
	/**
	 * openId
	 */
	private String openId;
	
	/**
	 * 兴趣爱好ID
	 */
	private Integer hobbiesId;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	private String hobbieName;
	
	public String getHobbieName() {
		return hobbieName;
	}

	public void setHobbieName(String hobbieName) {
		this.hobbieName = hobbieName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Integer getHobbiesId() {
		return hobbiesId;
	}

	public void setHobbiesId(Integer hobbiesId) {
		this.hobbiesId = hobbiesId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
