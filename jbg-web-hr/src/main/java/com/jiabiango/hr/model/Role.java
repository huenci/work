package com.jiabiango.hr.model;

import java.util.Date;
import java.util.List;

public class Role {

    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column jbg_role.id
     * @mbg.generated  Sun Mar 04 15:34:22 CST 2018
     */
    private Integer id;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column jbg_role.name
     * @mbg.generated  Sun Mar 04 15:34:22 CST 2018
     */
    private String name;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column jbg_role.remark
     * @mbg.generated  Sun Mar 04 15:34:22 CST 2018
     */
    private String remark;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column jbg_role.status
     * @mbg.generated  Sun Mar 04 15:34:22 CST 2018
     */
    private String status;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column jbg_role.create_by
     * @mbg.generated  Sun Mar 04 15:34:22 CST 2018
     */
    private String createBy;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column jbg_role.create_time
     * @mbg.generated  Sun Mar 04 15:34:22 CST 2018
     */
    private Date createTime;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column jbg_role.update_by
     * @mbg.generated  Sun Mar 04 15:34:22 CST 2018
     */
    private String updateBy;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column jbg_role.update_time
     * @mbg.generated  Sun Mar 04 15:34:22 CST 2018
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column jbg_role.id
     * @return  the value of jbg_role.id
     * @mbg.generated  Sun Mar 04 15:34:22 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column jbg_role.id
     * @param id  the value for jbg_role.id
     * @mbg.generated  Sun Mar 04 15:34:22 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column jbg_role.name
     * @return  the value of jbg_role.name
     * @mbg.generated  Sun Mar 04 15:34:22 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column jbg_role.name
     * @param name  the value for jbg_role.name
     * @mbg.generated  Sun Mar 04 15:34:22 CST 2018
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column jbg_role.remark
     * @return  the value of jbg_role.remark
     * @mbg.generated  Sun Mar 04 15:34:22 CST 2018
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column jbg_role.remark
     * @param remark  the value for jbg_role.remark
     * @mbg.generated  Sun Mar 04 15:34:22 CST 2018
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column jbg_role.status
     * @return  the value of jbg_role.status
     * @mbg.generated  Sun Mar 04 15:34:22 CST 2018
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column jbg_role.status
     * @param status  the value for jbg_role.status
     * @mbg.generated  Sun Mar 04 15:34:22 CST 2018
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column jbg_role.create_by
     * @return  the value of jbg_role.create_by
     * @mbg.generated  Sun Mar 04 15:34:22 CST 2018
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column jbg_role.create_by
     * @param createBy  the value for jbg_role.create_by
     * @mbg.generated  Sun Mar 04 15:34:22 CST 2018
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column jbg_role.create_time
     * @return  the value of jbg_role.create_time
     * @mbg.generated  Sun Mar 04 15:34:22 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column jbg_role.create_time
     * @param createTime  the value for jbg_role.create_time
     * @mbg.generated  Sun Mar 04 15:34:22 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column jbg_role.update_by
     * @return  the value of jbg_role.update_by
     * @mbg.generated  Sun Mar 04 15:34:22 CST 2018
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column jbg_role.update_by
     * @param updateBy  the value for jbg_role.update_by
     * @mbg.generated  Sun Mar 04 15:34:22 CST 2018
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column jbg_role.update_time
     * @return  the value of jbg_role.update_time
     * @mbg.generated  Sun Mar 04 15:34:22 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column jbg_role.update_time
     * @param updateTime  the value for jbg_role.update_time
     * @mbg.generated  Sun Mar 04 15:34:22 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    List<Resource> resources;

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}