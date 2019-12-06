package com.jiabiango.hr.wechat.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Token的Model类，可以增加字段提高安全性，例如时间戳、url签名
 * @author ScienJus
 * @date 2015/7/31.
 */
public class AuthToken implements Serializable {
    
    private static final long serialVersionUID = -2068525098069015248L;

    private String memberId;
    private String openId;
    private String unionId;
    private String accessToken;
    private String secretKey;
    private String ip;
    private String plat;
    //private String deviceId;
    private Integer status;
    private Date expireTime;
    private Date createTime;
	public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    public String getSecretKey() {
        return secretKey;
    }
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
    public String getPlat() {
        return plat;
    }
    public void setPlat(String plat) {
        this.plat = plat;
    }
    public Date getExpireTime() {
        return expireTime;
    }
    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public String getOpenId() {
        return openId;
    }
    public void setOpenId(String openId) {
        this.openId = openId;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getUnionId() {
        return unionId;
    }
    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }
}
