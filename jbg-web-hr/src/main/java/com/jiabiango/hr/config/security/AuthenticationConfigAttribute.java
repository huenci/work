package com.jiabiango.hr.config.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.util.Assert;

public class AuthenticationConfigAttribute extends SecurityConfig {

    public AuthenticationConfigAttribute(String config) {
        super(config);
    }

    private static final long serialVersionUID = 1L;
    
    public static List<ConfigAttribute> createList(String... attributeNames) {
        Assert.notNull(attributeNames, "You must supply an array of attribute names");
        List<ConfigAttribute> attributes = new ArrayList<ConfigAttribute>(
                attributeNames.length);

        for (String attribute : attributeNames) {
            attributes.add(new AuthenticationConfigAttribute(attribute.trim()));
        }

        return attributes;
    }

}
