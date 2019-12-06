package com.jiabiango.hr.admin.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiabiango.hr.config.security.UserHelper;
import com.jiabiango.hr.dto.UserPasswordDto;
import com.jiabiango.hr.dto.UserQueryDto;
import com.jiabiango.hr.exception.ApiException;
import com.jiabiango.hr.model.User;
import com.jiabiango.hr.pager.LayPageResult;
import com.jiabiango.hr.service.UserService;

@Controller
@RequestMapping("/admin")
public class UserController {
    @Autowired
    private UserHelper userHelper;

    @Autowired
    private UserService userService;
    
    @GetMapping("/user.html")
    public String list() {
        return "user/user";
    }
    
    @GetMapping("/user/edit.html")
    public String edit() {
        return "user/user_edit";
    }
    
    @GetMapping("/user/add.html")
    public String add() {
        return "user/user_add";
    }
    
    @GetMapping("/user/detail.html")
    public String detail(Model model) {
        model.addAttribute("user", userHelper.getCurrentUser());
        return "user/user_detail";
    }
    
    @GetMapping("/user/password.html")
    public String password() {
        return "user/user_password";
    }
    
    @GetMapping("/user")
    @ResponseBody
    public LayPageResult<User> queryUser(UserQueryDto query) {
        return userService.query(query);
    }
    
    @GetMapping("/user/{userId}")
    @ResponseBody
    public User getUser(@PathVariable("userId") Integer userId) {
        return userService.getById(userId);
    }
    
    @PutMapping("/user")
    @ResponseBody
    public void updateUser(@RequestBody User user) {
        userService.update(user);
    }
    
    @PostMapping("/user")
    @ResponseBody
    public void saveUser(@RequestBody User user) {
        if(StringUtils.isBlank(user.getUsername())) {
            throw new ApiException("用户名不能为空");
        }
        if(StringUtils.isBlank(user.getGender())) {
            throw new ApiException("性别不能为空");
        }
        if(StringUtils.isBlank(user.getPassword())) {
            throw new ApiException("密码不能为空");
        }
        if(StringUtils.isBlank(user.getRealName())) {
            throw new ApiException("姓名不能为空");
        }
        if(StringUtils.isBlank(user.getStatus())) {
            throw new ApiException("状态不能为空");
        }
        User dbUser = userService.getUser(user.getUsername());
        if(dbUser != null) {
            throw new ApiException("用户已存在");
        }
        userService.save(user);
    }
    
    @PutMapping("/user/password")
    @ResponseBody
    public void updateUserPassword(@RequestBody UserPasswordDto userPassword) {
        if(StringUtils.isBlank(userPassword.getRawPassword())) {
            throw new ApiException("原密码不能为空");
        }
        if(StringUtils.isBlank(userPassword.getNewPassword())) {
            throw new ApiException("新密码不能为空");
        }
        if(!userPassword.getNewPassword().equals(userPassword.getConfirmPassword())) {
            throw new ApiException("确认密码与新密码不一致");
        }
        User currUser = userHelper.getCurrentUser();
        userService.updatePassword(currUser, userPassword);;
    }
    
}
