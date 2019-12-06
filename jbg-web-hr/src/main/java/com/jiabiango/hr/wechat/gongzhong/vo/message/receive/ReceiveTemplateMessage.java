package com.jiabiango.hr.wechat.gongzhong.vo.message.receive;

import com.jiabiango.hr.wechat.gongzhong.vo.message.Message;


 
public class ReceiveTemplateMessage extends Message
{
	  private String event;
	  private String status;

	  public String getEvent()
	  {
	    return this.event; }

	  public void setEvent(String event) {
	    this.event = event; }

	  public String getStatus() {
	    return this.status; }

	  public void setStatus(String status) {
	    this.status = status;
	  }
	}