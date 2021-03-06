package com.jiabiango.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jiabiango.hr.model.Role;

public interface RoleMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table jbg_role
     * @mbg.generated  Sun Mar 04 15:34:22 CST 2018
     */
    int insert(Role record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table jbg_role
     * @mbg.generated  Sun Mar 04 15:34:22 CST 2018
     */
    int insertSelective(Role record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table jbg_role
     * @mbg.generated  Sun Mar 04 15:34:22 CST 2018
     */
    Role selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table jbg_role
     * @mbg.generated  Sun Mar 04 15:34:22 CST 2018
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table jbg_role
     * @mbg.generated  Sun Mar 04 15:34:22 CST 2018
     */
    int updateByPrimaryKey(Role record);

    List<Role> selectAll();
    Role selectByName(@Param("name")String name);
    
    int save(Role record);
}