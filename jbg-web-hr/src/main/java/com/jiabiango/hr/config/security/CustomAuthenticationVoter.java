package com.jiabiango.hr.config.security;

import java.util.Collection;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;

public class CustomAuthenticationVoter implements AccessDecisionVoter<FilterInvocation> {
    public static final String ALLOW = "allow";
    public static final String AUTHENTICATED = "authenticated";

    @Override
    public boolean supports(ConfigAttribute attribute) {
        if(attribute instanceof AuthenticationConfigAttribute) {
            return true;
        }
        return false;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }

    @Override
    public int vote(Authentication authentication, FilterInvocation object, Collection<ConfigAttribute> attributes) {
        if (attributes == null) {
            return ACCESS_ABSTAIN;
        }
        // 所请求的资源拥有的权限(一个资源对多个权限)
        for (ConfigAttribute configAttribute : attributes) {
            // 访问所请求资源所需要的权限
            String authority = configAttribute.getAttribute();
            if (AUTHENTICATED.equals(authority)) {
                if(!(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated()) {
                    return ACCESS_GRANTED;
                }
            } else if(ALLOW.equals(authority)) {
                return ACCESS_GRANTED;
            }
        }
        return ACCESS_DENIED;
    }

}
