package com.jiabiango.hr.wechat.gongzhong.vo.weboauth;

import com.jiabiango.hr.wechat.gongzhong.vo.message.WeChatErr;

public class OauthAccessToken extends WeChatErr{

	private String accessToken;
	private int expiresIn;
	private String refreshToken;
	private String openId;
	private String scope;
	private String grantType;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getGrantType() {
		return grantType;
	}

	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}

	@Override
	public String toString() {
		return "OauthAccessToken [accessToken=" + accessToken + ", expiresIn=" + expiresIn + ", refreshToken="
				+ refreshToken + ", openId=" + openId + ", scope=" + scope + ", grantType=" + grantType + "]";
	}
	
	
	
	
}
