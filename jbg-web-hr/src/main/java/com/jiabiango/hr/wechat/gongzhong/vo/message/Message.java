package com.jiabiango.hr.wechat.gongzhong.vo.message;

import com.jiabiango.hr.wechat.gongzhong.GongZhongObject;

 
public class Message extends GongZhongObject
{
	  public static final String TYPE_TEXT = "text";
	  public static final String TYPE_THUMB = "thumb";
	  public static final String TYPE_IMAGE = "image";
	  public static final String TYPE_VOICE = "voice";
	  public static final String TYPE_VIDEO = "video";
	  public static final String TYPE_LOCATION = "location";
	  public static final String TYPE_LINK = "link";
	  public static final String TYPE_EVENT = "event";
	  public static final String TYPE_TEMPLATESENDJOBFINISH = "TEMPLATESENDJOBFINISH";
	  private String toUserName;
	  private String fromUserName;
	  private long createTime;
	  private String msgType;
	  private long msgId;

	  public String getToUserName()
	  {
	    return this.toUserName;
	  }

	  public void setToUserName(String toUserName) {
	    this.toUserName = toUserName;
	  }

	  public String getFromUserName() {
	    return this.fromUserName;
	  }

	  public void setFromUserName(String fromUserName) {
	    this.fromUserName = fromUserName;
	  }

	  public long getCreateTime() {
	    return this.createTime;
	  }

	  public void setCreateTime(long createTime) {
	    this.createTime = createTime;
	  }

	  public String getMsgType() {
	    return this.msgType;
	  }

	  public void setMsgType(String msgType) {
	    this.msgType = msgType;
	  }

	  public long getMsgId() {
	    return this.msgId;
	  }

	  public void setMsgId(long msgId) {
	    this.msgId = msgId;
	  }
	}