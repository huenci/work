package com.jiabiango.hr.mapper;

import java.util.List;

import com.jiabiango.hr.model.Resource;
import com.jiabiango.hr.model.RoleResource;

public interface RoleResourceMapper {
    List<Resource> selectResourceByRoleId(Integer id);

    int batchInsert(List<RoleResource> roleResources);

    int updateRoleResource(RoleResource roleResource);
}