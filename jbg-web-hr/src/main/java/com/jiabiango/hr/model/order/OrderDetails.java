package com.jiabiango.hr.model.order;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDetails {
	/**
	 * 主键
	 */
	private Integer id ;
	
	/**
	 * 订单编号
	 */
	private String orderId;
	
	/**
	 * 商品编号
	 */
	private Integer productId;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 小标题
	 */
	private String stitle;
	
	/**
	 * 主图
	 */
	private String imageUrl;
	
	/**
	 * 金额
	 */
	private BigDecimal amount;
	
	/**
	 * 是否有活动
	 */
	private Integer isActivity;
	
	/**
	 * 活动价格
	 */
	private BigDecimal activityAmount;
	
	/**
	 * 活动开始时间
	 */
	private Date activityStartDate;

	/**
	 * 活动结束时间
	 */
	private Date activityEndDate;
	
	/**
	 * 创建时间
	 */
	private Date createDate;
	
	private Integer count;
	
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getIsActivity() {
		return isActivity;
	}

	public void setIsActivity(Integer isActivity) {
		this.isActivity = isActivity;
	}

	public BigDecimal getActivityAmount() {
		return activityAmount;
	}

	public void setActivityAmount(BigDecimal activityAmount) {
		this.activityAmount = activityAmount;
	}

	public Date getActivityStartDate() {
		return activityStartDate;
	}

	public void setActivityStartDate(Date activityStartDate) {
		this.activityStartDate = activityStartDate;
	}

	public Date getActivityEndDate() {
		return activityEndDate;
	}

	public void setActivityEndDate(Date activityEndDate) {
		this.activityEndDate = activityEndDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getStitle() {
		return stitle;
	}

	public void setStitle(String stitle) {
		this.stitle = stitle;
	}
	
}
