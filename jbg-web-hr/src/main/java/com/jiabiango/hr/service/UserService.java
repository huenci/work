package com.jiabiango.hr.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.plugins.Page;
import com.jiabiango.hr.config.security.Md5PasswordEncoder;
import com.jiabiango.hr.dto.UserPasswordDto;
import com.jiabiango.hr.dto.UserQueryDto;
import com.jiabiango.hr.exception.ApiException;
import com.jiabiango.hr.mapper.UserMapper;
import com.jiabiango.hr.model.User;
import com.jiabiango.hr.pager.LayPageResult;
import com.jiabiango.hr.pager.PageHelper;

@Component
public class UserService {

    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private Md5PasswordEncoder passwordEncoder;
    
    public User getUser(String username) {
        return userMapper.selectByUsername(username);
    }
    
    public User getById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
    
    public LayPageResult<User> query(UserQueryDto query) {
        Page<User> page = PageHelper.toPage(query);
        List<User> list = userMapper.query(page,query);
        page.setRecords(list);
        return PageHelper.toLayPageResult(page);
    }

    public void update(User user) {
        user.setUpdateTime(new Date());
        if(StringUtils.isNotBlank(user.getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        userMapper.updateByUserId(user);
    }
    
    public void updatePassword(User user, UserPasswordDto userPassword) {
        User dbUser = userMapper.selectByPrimaryKey(user.getId());
        if(!passwordEncoder.matches(userPassword.getRawPassword(), dbUser.getPassword())) {
            throw new ApiException("原密码不正确");
        }
        User updateUser = new User();
        updateUser.setId(dbUser.getId());
        updateUser.setExpireTime(dbUser.getExpireTime());
        updateUser.setPassword(passwordEncoder.encode(userPassword.getNewPassword()));
        userMapper.updateByUserId(updateUser);
    }

    public void save(User user) {
        user.setId(null);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreateTime(new Date());
        userMapper.insert(user);
    }
}
