package com.jiabiango.hr.model.area;

import java.util.List;

public class QulieList {
	private Integer quid;
	
	private Integer pai;
	
	private List<Qulie> qulieList;

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

	public List<Qulie> getQulieList() {
		return qulieList;
	}

	public void setQulieList(List<Qulie> qulieList) {
		this.qulieList = qulieList;
	}

}
