package com.jiabiango.hr.config.security;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;

@SuppressWarnings({"rawtypes", "unchecked"})
public class CustomAccessDecisionManager implements AccessDecisionManager {
    private final Log logger = LogFactory.getLog(getClass());
    
    private AccessDecisionVoter resourceVoter = new ResourceVoter();
    private AccessDecisionVoter authcationVoter = new CustomAuthenticationVoter();
    
    public void decide(Authentication authentication, Object object,
            Collection<ConfigAttribute> configAttributes) throws AccessDeniedException {
        int deny = 0;
        for(ConfigAttribute configAttribute : configAttributes) {
            if(resourceVoter.supports(configAttribute)) {
                int result = resourceVoter.vote(authentication, object, configAttributes);
                if(result == AccessDecisionVoter.ACCESS_DENIED) {
                    deny ++;
                }
            } else if(deny == 0 && authcationVoter.supports(configAttribute)) {
                int result = authcationVoter.vote(authentication, object, configAttributes);
                if(result == AccessDecisionVoter.ACCESS_DENIED) {
                    deny ++;
                }
            }
        }
        
        if(deny > 0) {
            throw new AccessDeniedException("Access is denied");
        }
    }

    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}