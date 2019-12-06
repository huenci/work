package com.jiabiango.hr.dto;

import com.jiabiango.hr.pager.PageParam;

public class UserQueryDto extends PageParam{
    private String username;
    private String realName;
    private String status;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getRealName() {
        return realName;
    }
    public void setRealName(String realName) {
        this.realName = realName;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}

