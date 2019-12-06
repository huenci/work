package com.jiabiango.hr.config.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.util.Assert;

import com.jiabiango.hr.model.Resource;

public class ResourceConfigAttribute implements ConfigAttribute {
    private static final long serialVersionUID = 1L;
    
    private String authority;
    private String url;
    private String httpMethod;
    
    public ResourceConfigAttribute(Resource resource) {
        this.authority = resource.getAuthority();
        this.url = resource.getUrl();
        this.httpMethod = resource.getHttpMethod();
    }
    
    @Override
    public String getAttribute() {
        return this.authority;
    }
    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((authority == null) ? 0 : authority.hashCode());
        result = prime * result + ((httpMethod == null) ? 0 : httpMethod.hashCode());
        result = prime * result + ((url == null) ? 0 : url.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ResourceConfigAttribute other = (ResourceConfigAttribute) obj;
        if (authority == null) {
            if (other.authority != null)
                return false;
        } else if (!authority.equals(other.authority))
            return false;
        if (httpMethod == null) {
            if (other.httpMethod != null)
                return false;
        } else if (!httpMethod.equals(other.httpMethod))
            return false;
        if (url == null) {
            if (other.url != null)
                return false;
        } else if (!url.equals(other.url))
            return false;
        return true;
    }

    public static List<ConfigAttribute> createList(Resource...resources) {
        Assert.notNull(resources, "You must supply an collection of resources");
        List<ConfigAttribute> attributes = new ArrayList<ConfigAttribute>(resources.length);
        for (Resource resource : resources) {
            attributes.add(new ResourceConfigAttribute(resource));
        }

        return attributes;
    }

    public String getAuthority() {
        return authority;
    }

    public String getUrl() {
        return url;
    }

    public String getHttpMethod() {
        return httpMethod;
    }
}
