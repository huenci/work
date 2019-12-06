package com.jiabiango.hr.wechat.gongzhong.vo.message.reply;

import com.jiabiango.hr.wechat.gongzhong.vo.message.Message;

 
public class ReplyVoiceMessage extends Message {
	private String mediaId;

	public String getMediaId() {
		return this.mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public void setMsgType(String msgType) {
		if (!("voice".equals(msgType)))
			throw new RuntimeException("msgType必须为：voice");

		super.setMsgType(msgType);
	}

	public String getMsgType() {
		return "voice";
	}
}
