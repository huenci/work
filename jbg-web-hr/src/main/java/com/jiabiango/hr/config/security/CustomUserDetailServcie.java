package com.jiabiango.hr.config.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.jiabiango.hr.model.User;
import com.jiabiango.hr.service.UserRoleService;
import com.jiabiango.hr.service.UserService;
import com.jiabiango.hr.util.JsonUtil;

@Component
public class CustomUserDetailServcie implements UserDetailsService {
    @Autowired
    private UserService userService;
    
    @Autowired
    private UserRoleService userRoleService;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUser(username);
        if(user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        CustomUserDetails userDetails = JsonUtil.parse(JsonUtil.toJson(user), CustomUserDetails.class);
        Set<String> authorities = userRoleService.getRoleAuthorities(userDetails.getId());
        Set<SimpleGrantedAuthority> userAuthorities = new HashSet<>();
        for(String authority: authorities) {
            userAuthorities.add(new SimpleGrantedAuthority(authority));
        }
        userDetails.setAuthorities(userAuthorities);
        return userDetails;
    }

}
