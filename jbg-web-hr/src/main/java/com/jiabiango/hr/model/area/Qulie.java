package com.jiabiango.hr.model.area;

public class Qulie {
	private Integer id;
	
	private Integer quid;
	
	private Integer pai;
	
	private Integer lie;
	
	private Integer biaoshi;//1标识 定 2标识 
	
	/**
	 * allinfoId
	 */
	private Integer allinfoId;
	
	/**
	 * 安葬时间
	 */
	private String anzangshijian;
	
	

	public Integer getAllinfoId() {
		return allinfoId;
	}

	public void setAllinfoId(Integer allinfoId) {
		this.allinfoId = allinfoId;
	}

	public String getAnzangshijian() {
		return anzangshijian;
	}

	public void setAnzangshijian(String anzangshijian) {
		this.anzangshijian = anzangshijian;
	}

	public Integer getBiaoshi() {
		return biaoshi;
	}

	public void setBiaoshi(Integer biaoshi) {
		this.biaoshi = biaoshi;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuid() {
		return quid;
	}

	public void setQuid(Integer quid) {
		this.quid = quid;
	}

	public Integer getPai() {
		return pai;
	}

	public void setPai(Integer pai) {
		this.pai = pai;
	}

	public Integer getLie() {
		return lie;
	}

	public void setLie(Integer lie) {
		this.lie = lie;
	}
	
}
