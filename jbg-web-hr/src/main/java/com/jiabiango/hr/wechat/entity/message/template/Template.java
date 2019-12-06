package com.jiabiango.hr.wechat.entity.message.template;

/**
 * @describe 推送模版消息实体类
 * @author lukas  414024003@qq.com
 * @date 2017年12月26日16:53:31
 * @version 1.0
 */
public class Template 
{
	  private String key;
	  private String value;
	  private String color;

	  public String getKey()
	  {
	    return this.key; }

	  public void setKey(String key) {
	    this.key = key; }

	  public String getValue() {
	    return this.value; }

	  public void setValue(String value) {
	    this.value = value; }

	  public String getColor() {
	    return this.color; }

	  public void setColor(String color) {
	    this.color = color;
	  }

	@Override
	public String toString() {
		return "Template [key=" + key + ", value=" + value + ", color=" + color
				+ "]";
	}
	  
	}
