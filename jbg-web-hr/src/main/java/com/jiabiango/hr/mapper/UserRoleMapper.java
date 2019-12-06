package com.jiabiango.hr.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.jiabiango.hr.model.Resource;
import com.jiabiango.hr.model.Role;
import com.jiabiango.hr.model.UserRole;

public interface UserRoleMapper {
    List<Role> selectRoleByUserId(@Param("userId")Integer userId);
    Set<String> selectRoleAuthorities(@Param("userId")Integer userId);
    
    int updateUserRole(UserRole userRole);
    int insert(UserRole userRole);
    UserRole selectByUserIdAndRole(@Param("userId")Integer userId, @Param("roleId")Integer roleId);
    List<Resource> selectRoleMenu(@Param("userId")Integer userId);
}
