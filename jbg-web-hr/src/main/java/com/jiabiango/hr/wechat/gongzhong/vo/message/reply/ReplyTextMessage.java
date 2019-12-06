package com.jiabiango.hr.wechat.gongzhong.vo.message.reply;

import com.jiabiango.hr.wechat.gongzhong.vo.message.Message;

 
public class ReplyTextMessage extends Message {
	private String Content;

	public String getContent() {
		return this.Content;
	}

	public void setContent(String content) {
		this.Content = content;
	}

	public void setMsgType(String msgType) {
		if (!("text".equals(msgType)))
			throw new RuntimeException("msgType必须为：text");

		super.setMsgType(msgType);
	}

	public String getMsgType() {
		return "text";
	}
}