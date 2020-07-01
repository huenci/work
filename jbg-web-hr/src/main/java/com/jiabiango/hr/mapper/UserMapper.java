package com.jiabiango.hr.mapper;

import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;
import com.jiabiango.hr.dto.UserQueryDto;
import com.jiabiango.hr.model.User;

public interface UserMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table jbg_user
     * @mbg.generated  Wed Feb 28 15:33:40 CST 2018
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table jbg_user
     * @mbg.generated  Wed Feb 28 15:33:40 CST 2018
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table jbg_user
     * @mbg.generated  Wed Feb 28 15:33:40 CST 2018
     */
    User selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table jbg_user
     * @mbg.generated  Wed Feb 28 15:33:40 CST 2018
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table jbg_user
     * @mbg.generated  Wed Feb 28 15:33:40 CST 2018
     */
    int updateByPrimaryKey(User record);

    int updateByUserId(User record);

    User selectByUsername(String username);
    
    List<User> query(Page<User> page, UserQueryDto query);
}