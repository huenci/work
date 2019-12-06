package com.jiabiango.hr.config.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.jiabiango.hr.constant.ResourceType;
import com.jiabiango.hr.model.Resource;
import com.jiabiango.hr.service.ResourceService;

public class ResourceSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    public static final String PATTERN_MATCH_TYPE = "pattern";
    
    // url全匹配，提升查询速度
    private static Map<String, Collection<ConfigAttribute>> fullMatcherResourceMap = null;
    // url模糊匹配，性能不高，少配
    private static Map<String, Collection<ConfigAttribute>> patternResourceMap = null;
    public static volatile boolean isLoaded = false;
    
    private Map<String, ConfigAttribute> defaultFullResourceMap = new LinkedHashMap<String, ConfigAttribute>();
    private Map<String, ConfigAttribute> defaultPatternResourceMap = new LinkedHashMap<String, ConfigAttribute>();
    

    @Autowired
    private ResourceService resourceService;
    
    public void addFullResource(String url, ConfigAttribute configAttribute) {
    	defaultFullResourceMap.put(url, configAttribute);
    }
    
    public void addPatternResource(String url, ConfigAttribute configAttribute) {
    	defaultPatternResourceMap.put(url, configAttribute);
    }
    
    public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

    // 返回所请求资源所需要的权限
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        try {
            loadResource();
        } catch (AuthenticationCredentialsNotFoundException e) {
            return AuthenticationConfigAttribute.createList(CustomAuthenticationVoter.AUTHENTICATED);
        }
        Collection<ConfigAttribute> configAttributes = new ArrayList<>();
        if (object instanceof FilterInvocation) {
            String requestUrl = ((FilterInvocation) object).getRequest().getRequestURI();
            if (fullMatcherResourceMap.get(requestUrl) != null) {
                String httpMethod = ((FilterInvocation) object).getRequest().getMethod();
                for(ConfigAttribute attribute : fullMatcherResourceMap.get(requestUrl)) {
                    if(attribute instanceof ResourceConfigAttribute) {
                        ResourceConfigAttribute resourceConfigAttribute = (ResourceConfigAttribute)attribute;
                        if(StringUtils.isBlank(resourceConfigAttribute.getHttpMethod())) {
                            configAttributes.add(resourceConfigAttribute);
                        } else if(httpMethod.equalsIgnoreCase(resourceConfigAttribute.getHttpMethod())){
                            configAttributes.add(resourceConfigAttribute);
                        }
                    } else {
                        configAttributes.add(attribute);
                    }
                }
            }
        }

        for (String resUrl : patternResourceMap.keySet()) {
            if (resUrl == null) {
                continue;
            }
            RequestMatcher pathMatcher = new AntPathRequestMatcher(resUrl);
            if (pathMatcher.matches(((FilterInvocation) object).getRequest())) {
                Collection<ConfigAttribute> attributes = patternResourceMap.get(resUrl);
                if (attributes != null) {
                    configAttributes.addAll(attributes);
                }
                return configAttributes;
            }
        }
        return null;
    }

    private void loadResource() {
//        isLoaded = false;
        if (!isLoaded) {
            List<Resource> resources = resourceService.getAll();
            synchronized (ResourceSecurityMetadataSource.class) {
                if (!isLoaded) {
                    fullMatcherResourceMap = new LinkedHashMap<String, Collection<ConfigAttribute>>();
                    patternResourceMap = new LinkedHashMap<String, Collection<ConfigAttribute>>();
                    for (Resource resource : resources) {
                        String url = resource.getUrl();
                        if(StringUtils.isBlank(url)) {
                            continue;
                        }
                        if(!(ResourceType.API.equals(resource.getType()) || ResourceType.PAGE.equals(resource.getType()))) {
                            continue;
                        }
                        if(PATTERN_MATCH_TYPE.equals(resource.getMatchType())) {
                            Collection<ConfigAttribute> configAttributes = patternResourceMap.get(url);
                            if(configAttributes != null) {
                                configAttributes.add(new ResourceConfigAttribute(resource));
                            } else {
                                patternResourceMap.put(url, ResourceConfigAttribute.createList(resource));
                            }
                        } else {
                            Collection<ConfigAttribute> configAttributes = fullMatcherResourceMap.get(url);
                            if(configAttributes != null) {
                                configAttributes.add(new ResourceConfigAttribute(resource));
                            } else {
                                fullMatcherResourceMap.put(url, ResourceConfigAttribute.createList(resource));
                            }
                        }
                    }
                    
                    for(Entry<String, ConfigAttribute> entry : defaultFullResourceMap.entrySet()) {
                    	fullMatcherResourceMap.put(entry.getKey(), Collections.singletonList(entry.getValue()));
                    }
                    
                    for(Entry<String, ConfigAttribute> entry : defaultPatternResourceMap.entrySet()) {
                    	patternResourceMap.put(entry.getKey(), Collections.singletonList(entry.getValue()));
                    }
                    isLoaded = true;
                }
            }
        }
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}