package com.jiabiango.hr.wechat.gongzhong.vo.message.receive;

import com.jiabiango.hr.wechat.gongzhong.vo.message.Message;


 
public class ReceiveVoiceMessage extends Message {
	private String mediaId;
	private String format;
	private String recognition;

	public String getMediaId() {
		return this.mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getFormat() {
		return this.format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getRecognition() {
		return this.recognition;
	}

	public void setRecognition(String recognition) {
		this.recognition = recognition;
	}
}
