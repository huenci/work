package com.jiabiango.hr.wechat.gongzhong.vo.message.receive;

import com.jiabiango.hr.wechat.gongzhong.vo.message.Message;


 
public class ReceiveScanMessage extends Message {
	public static final String EVENT_SCAN = "SCAN";
	private String event;
	private String eventKey;
	 private String ticket;

	public String getEvent() {
		return this.event;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getEventKey() {
		return this.eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	@Override
	public String toString() {
		return "ReceiveScanMessage [event=" + event + ", eventKey=" + eventKey
				+ ", ticket=" + ticket + "]";
	}
	
}