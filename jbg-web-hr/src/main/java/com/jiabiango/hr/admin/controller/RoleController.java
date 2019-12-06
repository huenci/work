package com.jiabiango.hr.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiabiango.hr.model.Role;
import com.jiabiango.hr.service.RoleService;

@Controller
@RequestMapping("/admin")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/role.html")
    public String list() {
        return "role/role";
    }
    
    @GetMapping("/role")
    @ResponseBody
    public List<Role> get() {
        return roleService.getAll();
    }
    
    @GetMapping("/role/resource")
    @ResponseBody
    public Role getRoleResources(Integer roleId) {
        return roleService.getRoleWithResources(roleId);
    }
    
    @PutMapping("/role")
    @ResponseBody
    public Role updateRole(@RequestBody Role role) {
        return roleService.update(role);
    }
    
    @PostMapping("/role")
    @ResponseBody
    public Role saveRole(@RequestBody Role role) {
        return roleService.save(role);
    }
    
    @DeleteMapping("/role")
    @ResponseBody
    public Role delRole(@RequestBody Role role) {
        return roleService.del(role);
    }
}
