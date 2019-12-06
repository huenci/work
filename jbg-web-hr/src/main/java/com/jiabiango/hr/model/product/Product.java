package com.jiabiango.hr.model.product;

import java.math.BigDecimal;
import java.util.Date;

public class Product implements  Comparable<Product>{
	/**
	 * 主键
	 */
	private Integer id ;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 小标题
	 */
	private String stitle;
	
	/**
	 * 分类
	 */
	private Integer classType;
	
	/**
	 * 主图
	 */
	private String imageUrl;
	
	/**
	 * 详图
	 */
	private String detailsImageUrl;
	
	/**
	 * 金额
	 */
	private BigDecimal amount;
	
	/**
	 * 单位
	 */
	private String company;
	
	/**
	 * 状态
	 */
	private Integer status;
	
	/**
	 * 推荐标签
	 */
	private Integer rendStatus;
	
	/**
	 * 库存数量
	 */
	private Integer productNumber;
	
	/**
	 * 周期
	 */
	private Integer cycle;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 是否有活动
	 */
	private Integer isActivity;
	
	/**
	 * 是否推荐
	 */
	private Integer isRecommend;
	
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

	private String rendName;
	/**
	 * 开始时间
	 */
	private String startDate;
	/**
	 * 结束时间
	 */
	private String endDate;
	
	/**
	 * 已购数量
	 */
	private Integer surplusNumber;
	
	/**
	 * 是否固定时间
	 */
	private Integer isLockTime;
	
	public Integer getSurplusNumber() {
		return surplusNumber;
	}

	public void setSurplusNumber(Integer surplusNumber) {
		this.surplusNumber = surplusNumber;
	}

	public Integer getIsLockTime() {
		return isLockTime;
	}

	public void setIsLockTime(Integer isLockTime) {
		this.isLockTime = isLockTime;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getRendName() {
		return rendName;
	}

	public void setRendName(String rendName) {
		this.rendName = rendName;
	}

	public Integer getRendStatus() {
		return rendStatus;
	}

	public void setRendStatus(Integer rendStatus) {
		this.rendStatus = rendStatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getDetailsImageUrl() {
		return detailsImageUrl;
	}

	public void setDetailsImageUrl(String detailsImageUrl) {
		this.detailsImageUrl = detailsImageUrl;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getIsActivity() {
		return isActivity;
	}

	public void setIsActivity(Integer isActivity) {
		this.isActivity = isActivity;
	}

	public Integer getIsRecommend() {
		return isRecommend;
	}

	public void setIsRecommend(Integer isRecommend) {
		this.isRecommend = isRecommend;
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

	public Integer getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(Integer productNumber) {
		this.productNumber = productNumber;
	}

	public String getStitle() {
		return stitle;
	}

	public void setStitle(String stitle) {
		this.stitle = stitle;
	}

	public Integer getClassType() {
		return classType;
	}

	public void setClassType(Integer classType) {
		this.classType = classType;
	}

	public Integer getCycle() {
		return cycle;
	}

	public void setCycle(Integer cycle) {
		this.cycle = cycle;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override  
    public int compareTo(Product o) {  
        return new Integer(o.getSurplusNumber()).compareTo(this.getSurplusNumber());  
    }
}
