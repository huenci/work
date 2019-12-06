package com.jiabiango.hr.config.security;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jiabiango.hr.constant.UserStatus;
import com.jiabiango.hr.model.User;

public class CustomUserDetails extends User implements UserDetails {
    private static final long serialVersionUID = 6251463424643570004L;

    private Set<? extends GrantedAuthority> authorities;
    
    public void setAuthorities(Set<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        if(getExpireTime() != null) {
            return getExpireTime().after(new Date());
        }
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !UserStatus.LOCKED.equals(getStatus());
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return UserStatus.NORMAL.equals(getStatus());
    }

}
