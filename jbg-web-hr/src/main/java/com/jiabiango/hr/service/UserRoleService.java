package com.jiabiango.hr.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiabiango.hr.constant.DataStatus;
import com.jiabiango.hr.constant.ResourceType;
import com.jiabiango.hr.dto.UserMenuDto;
import com.jiabiango.hr.mapper.UserMapper;
import com.jiabiango.hr.mapper.UserRoleMapper;
import com.jiabiango.hr.model.Resource;
import com.jiabiango.hr.model.Role;
import com.jiabiango.hr.model.User;
import com.jiabiango.hr.model.UserRole;

@Service
public class UserRoleService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    public User getUserWithRoles(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        List<Role> roles = userRoleMapper.selectRoleByUserId(userId);
        user.setRoles(roles);
        return user;
    }

    public List<Role> getUserRoles(Integer userId) {
        List<Role> roles = userRoleMapper.selectRoleByUserId(userId);
        return roles;
    }

    public List<UserMenuDto> getUserMenu(Integer userId) {
        List<Resource> resourceMenus = userRoleMapper.selectRoleMenu(userId);
        Map<Integer, UserMenuDto> groupMenuMap = new LinkedHashMap<>(resourceMenus.size());
        for (Resource resource : resourceMenus) {
            if (ResourceType.MENU_GROUP.equals(resource.getType())) {
                UserMenuDto userMenuDto = new UserMenuDto(resource);
                groupMenuMap.put(resource.getId(), userMenuDto);
            }
        }
        for (Resource resource : resourceMenus) {
            if (ResourceType.MENU_GROUP.equals(resource.getType())) {
                continue;
            }
            UserMenuDto groupMenu = groupMenuMap.get(resource.getParentId());
            if (groupMenu != null) {
                List<UserMenuDto> menus = groupMenu.getSubMenus();
                if (menus == null) {
                    menus = new ArrayList<>();
                    groupMenu.setSubMenus(menus);
                }
                menus.add(new UserMenuDto(resource));
            }
        }
        List<UserMenuDto> userMenus = new ArrayList<>(groupMenuMap.size());
        for (Integer resourceId : groupMenuMap.keySet()) {
            userMenus.add(groupMenuMap.get(resourceId));
        }
        return userMenus;
    }

    public Set<String> getRoleAuthorities(Integer userId) {
        Set<String> authorities = userRoleMapper.selectRoleAuthorities(userId);
        return authorities;
    }

    public UserRole patchUserRole(UserRole userRole) {
        UserRole dbUserRole = userRoleMapper.selectByUserIdAndRole(userRole.getUserId(), userRole.getRoleId());
        if (dbUserRole != null) {
            if (DataStatus.VALID.equals(userRole.getStatus())) {
                return dbUserRole;
            } else {
                // 取消角色操作
                UserRole updateUserRole = new UserRole();
                updateUserRole.setUserId(dbUserRole.getUserId());
                updateUserRole.setRoleId(dbUserRole.getRoleId());
                updateUserRole.setUpdateTime(new Date());
                updateUserRole.setStatus(DataStatus.DELETED);
                userRoleMapper.updateUserRole(updateUserRole);

                return updateUserRole;
            }
        } else {
            if (DataStatus.VALID.equals(userRole.getStatus())) {
                userRole.setId(null);
                userRole.setCreateTime(new Date());
                userRoleMapper.insert(userRole);
                return userRole;
            } else {
                return userRole;
            }
        }
    }
}
