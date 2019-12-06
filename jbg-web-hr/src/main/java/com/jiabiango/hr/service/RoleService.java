package com.jiabiango.hr.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jiabiango.hr.constant.DataStatus;
import com.jiabiango.hr.constant.RoleResourceStatus;
import com.jiabiango.hr.exception.ApiException;
import com.jiabiango.hr.mapper.RoleMapper;
import com.jiabiango.hr.mapper.RoleResourceMapper;
import com.jiabiango.hr.model.Resource;
import com.jiabiango.hr.model.Role;
import com.jiabiango.hr.model.RoleResource;

@Component
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleResourceMapper roleResourceMapper;

    public Role getRole(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    public List<Role> getAll() {
        List<Role> list = roleMapper.selectAll();
        return list;
    }

    public Role getRoleWithResources(Integer id) {
        Role role = roleMapper.selectByPrimaryKey(id);
        List<Resource> resources = roleResourceMapper.selectResourceByRoleId(role.getId());
        role.setResources(resources);
        return role;
    }

    @Transactional
    public Role update(Role role) {
        role.setUpdateTime(new Date());
        roleMapper.updateByPrimaryKeySelective(role);

        // 删除现有关系
        RoleResource updateRoleResource = new RoleResource();
        updateRoleResource.setRoleId(role.getId());
        updateRoleResource.setStatus(RoleResourceStatus.DELETED);
        updateRoleResource.setUpdateTime(new Date());
        roleResourceMapper.updateRoleResource(updateRoleResource);

        List<Resource> resources = role.getResources();
        if (resources != null && resources.size() > 0) {
            List<RoleResource> roleResources = new ArrayList<>();
            for (Resource resource : resources) {
                RoleResource roleResource = new RoleResource();
                roleResource.setResourceId(resource.getId());
                roleResource.setRoleId(role.getId());
                roleResource.setCreateTime(new Date());
                roleResource.setStatus(RoleResourceStatus.NORMAL);
                roleResources.add(roleResource);
            }
            roleResourceMapper.batchInsert(roleResources);
        }
        return role;
    }

    @Transactional
    public Role save(Role role) {
        Role dbRole = roleMapper.selectByName(role.getName());
        if (dbRole != null) {
            throw new ApiException("该角色已存在，请更换别的角色名");
        }

        role.setId(null);
        role.setStatus(RoleResourceStatus.NORMAL);
        role.setCreateTime(new Date());
        roleMapper.save(role);

        List<Resource> resources = role.getResources();
        if (resources != null && resources.size() > 0) {
            List<RoleResource> roleResources = new ArrayList<>();
            for (Resource resource : resources) {
                RoleResource roleResource = new RoleResource();
                roleResource.setResourceId(resource.getId());
                roleResource.setRoleId(role.getId());
                roleResource.setCreateTime(new Date());
                roleResource.setStatus(RoleResourceStatus.NORMAL);
                roleResources.add(roleResource);
            }
            roleResourceMapper.batchInsert(roleResources);
        }

        return role;
    }

    public Role del(Role role) {
        Role delRole = new Role();
        delRole.setId(role.getId());
        delRole.setStatus(DataStatus.DELETED);
        roleMapper.updateByPrimaryKeySelective(delRole);
        role.setStatus(DataStatus.DELETED);
        return role;
    }
}
