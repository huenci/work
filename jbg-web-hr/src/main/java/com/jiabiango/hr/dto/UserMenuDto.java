package com.jiabiango.hr.dto;

import java.io.Serializable;
import java.util.List;

import com.jiabiango.hr.model.Resource;

public class UserMenuDto implements Serializable {
	private static final long serialVersionUID = 1777946340144220165L;
	private Integer id;
    private String name;
    private String url;
    private String type;
    private List<UserMenuDto> subMenus;
    
    public UserMenuDto(Resource resource) {
        this.name = resource.getName();
        this.url = resource.getUrl();
        this.type = resource.getType();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        UserMenuDto other = (UserMenuDto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public List<UserMenuDto> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<UserMenuDto> subMenus) {
        this.subMenus = subMenus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
}
