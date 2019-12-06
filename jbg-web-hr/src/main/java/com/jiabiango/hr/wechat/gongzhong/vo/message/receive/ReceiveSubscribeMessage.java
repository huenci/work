package com.jiabiango.hr.wechat.gongzhong.vo.message.receive;

import com.jiabiango.hr.wechat.gongzhong.vo.message.Message;

 
public class ReceiveSubscribeMessage extends Message
{
	  public static final String EVENT_SUBSCRIBE = "subscribe";
	  public static final String EVENT_UNSUBSCRIBE = "unsubscribe";
	  private String event;
	  private String eventKey;
	  private String ticket;

	  public String getEvent()
	  {
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

	  public String getTicket() {
	    return this.ticket;
	  }

	  public void setTicket(String ticket) {
	    this.ticket = ticket;
	  }
	}
