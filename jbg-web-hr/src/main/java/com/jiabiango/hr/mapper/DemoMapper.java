package com.jiabiango.hr.mapper;

import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;
import com.jiabiango.hr.dto.DemoQueryDto;
import com.jiabiango.hr.model.Demo;

public interface DemoMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table jbg_demo
     * @mbg.generated  Wed Feb 07 10:15:56 CST 2018
     */
    int insert(Demo record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table jbg_demo
     * @mbg.generated  Wed Feb 07 10:15:56 CST 2018
     */
    int insertSelective(Demo record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table jbg_demo
     * @mbg.generated  Wed Feb 07 10:15:56 CST 2018
     */
    Demo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table jbg_demo
     * @mbg.generated  Wed Feb 07 10:15:56 CST 2018
     */
    int updateByPrimaryKeySelective(Demo record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table jbg_demo
     * @mbg.generated  Wed Feb 07 10:15:56 CST 2018
     */
    int updateByPrimaryKey(Demo record);

    List<Demo> query(Page<Demo> page, DemoQueryDto query);
}