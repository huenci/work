package com.jiabiango.hr.config.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.jiabiango.hr.model.User;

@Component
public class UserHelper {

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof UsernamePasswordAuthenticationToken)) {
            return null;
        }
        CustomUserDetails customUserDetails = (CustomUserDetails)(authentication.getPrincipal());
        return customUserDetails;
    }
}
