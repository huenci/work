package com.jiabiango.hr.wechat.gongzhong.vo.message;


/**
 * @category说明：微信接口返回消息
 * @author创建人：lukas
 * @date创建时间：2017年12月26日17:01:07
 * @emial邮箱：414024003@163.com
 */
public class WeChatErr {
	
	/**
	 * 返回错误代码
	 */
	private String errCode;
	
	/**
	 * 返回错误消息
	 */
	private String errMsg;

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	

}
