package com.usa.zhiben.bean.web.user;

import java.util.Date;

public class Group {
    /**
     *
     */
    private Integer id;

    /**
     * 群组名  相当于  角色名称
     */
    private String groupName;

    /**
     * 分配的等级  1 管理员 2 超级用户 3 一般用户
     */
    private Integer groupLevels;

    /**
     * 群组状态 1默认群组 不能删
     */
    private Integer groupStatus;

    /**
     * 创建者
     */
    private String creater;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    private Date updateTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 群组名  相当于  角色名称
     *
     * @return group_name 群组名  相当于  角色名称
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 群组名  相当于  角色名称
     *
     * @param groupName 群组名  相当于  角色名称
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    /**
     * 分配的等级  1 管理员 2 超级用户 3 一般用户
     *
     * @return group_levels 分配的等级  1 管理员 2 超级用户 3 一般用户
     */
    public Integer getGroupLevels() {
        return groupLevels;
    }

    /**
     * 分配的等级  1 管理员 2 超级用户 3 一般用户
     *
     * @param groupLevels 分配的等级  1 管理员 2 超级用户 3 一般用户
     */
    public void setGroupLevels(Integer groupLevels) {
        this.groupLevels = groupLevels;
    }

    /**
     * 群组状态 1默认群组 不能删
     *
     * @return group_status 群组状态 1默认群组 不能删
     */
    public Integer getGroupStatus() {
        return groupStatus;
    }

    /**
     * 群组状态 1默认群组 不能删
     *
     * @param groupStatus 群组状态 1默认群组 不能删
     */
    public void setGroupStatus(Integer groupStatus) {
        this.groupStatus = groupStatus;
    }

    /**
     * 创建者
     *
     * @return creater 创建者
     */
    public String getCreater() {
        return creater;
    }

    /**
     * 创建者
     *
     * @param creater 创建者
     */
    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}