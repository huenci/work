package com.jiabiango.hr.wechat.gongzhong.vo.message.receive;

import com.jiabiango.hr.wechat.gongzhong.vo.message.Message;


 
public class ReceiveLoctionMessage extends Message {
	public static final String envet = "";
	private double latitude;
	private double longitude;
	private double precision;

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getPrecision() {
		return this.precision;
	}

	public void setPrecision(double precision) {
		this.precision = precision;
	}
}
