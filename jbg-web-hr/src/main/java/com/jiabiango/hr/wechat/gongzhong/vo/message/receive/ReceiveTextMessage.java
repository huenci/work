package com.jiabiango.hr.wechat.gongzhong.vo.message.receive;

import com.jiabiango.hr.wechat.gongzhong.vo.message.Message;

 
public class ReceiveTextMessage extends Message
{
	  private String Content;

	  public String getContent()
	  {
	    return this.Content;
	  }

	  public void setContent(String content) {
	    this.Content = content;
	  }
	}
