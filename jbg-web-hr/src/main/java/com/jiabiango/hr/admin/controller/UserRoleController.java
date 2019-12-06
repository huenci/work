package com.jiabiango.hr.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiabiango.hr.model.Role;
import com.jiabiango.hr.model.UserRole;
import com.jiabiango.hr.service.UserRoleService;

@Controller
@RequestMapping("/admin")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleServcie;
    
    @GetMapping("/user/role.html")
    public String userRole() {
        return "user/user_role";
    }
    
    @GetMapping("/user/role")
    @ResponseBody
    public List<Role> getUserRole(Integer userId) {
        return userRoleServcie.getUserRoles(userId);
    }
    
    @PatchMapping("/user/role")
    @ResponseBody
    public UserRole patchUserRole(@RequestBody UserRole userRole) {
        return userRoleServcie.patchUserRole(userRole);
    }
}
