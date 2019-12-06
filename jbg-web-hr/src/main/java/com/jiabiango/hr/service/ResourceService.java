package com.jiabiango.hr.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jiabiango.hr.constant.DataStatus;
import com.jiabiango.hr.mapper.ResourceMapper;
import com.jiabiango.hr.model.Resource;

@Component
public class ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;
    
    public Resource getResource(Integer id) {
        return resourceMapper.selectByPrimaryKey(id);
    }
    
    public List<Resource> getAll() {
        List<Resource> list = resourceMapper.selectAll();
        return list;
    }

    public Resource update(Resource resource) {
        resource.setUpdateTime(new Date());
        resourceMapper.update(resource);
        return resource;
    }

    public Resource save(Resource resource) {
        resource.setId(null);
        resource.setStatus(DataStatus.VALID);
        resource.setCreateTime(new Date());
        resourceMapper.save(resource);
        return resource;
    }

    public Resource del(Resource resource) {
        Resource delResource = new Resource();
        delResource.setId(resource.getId());
        delResource.setStatus(DataStatus.DELETED);
        resourceMapper.updateByPrimaryKeySelective(delResource);
        resource.setStatus(DataStatus.DELETED);
        return resource;
    }
}
