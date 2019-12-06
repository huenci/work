package com.jiabiango.hr.wechat.gongzhong.vo.message.receive;

import com.jiabiango.hr.wechat.gongzhong.vo.message.Message;



public class ReceiveClickMessage extends Message {
	public static final String EVENT_CLICK = "CLICK";
	public static final String EVENT_VIEW = "VIEW";
	private String event;
	private String eventKey;

	public String getEvent() {
		return this.event;
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
}