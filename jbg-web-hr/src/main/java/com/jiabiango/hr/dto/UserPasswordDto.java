package com.jiabiango.hr.dto;

public class UserPasswordDto {
    private String rawPassword;
    private String newPassword;
    private String confirmPassword;
    
    public String getRawPassword() {
        return rawPassword;
    }
    public void setRawPassword(String rawPassword) {
        this.rawPassword = rawPassword;
    }
    public String getNewPassword() {
        return newPassword;
    }
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    
}
