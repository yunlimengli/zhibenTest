package com.usa.zhiben.bean.web.user;

import java.util.Date;

public class Permission {
    /**
     *
     */
    private Integer id;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限描述
     */
    private String description;

    /**
     * 权限访问路径
     */
    private String url;

    /**
     * 权限标识
     */
    private String perms;

    /**
     * 父级权限id
     */
    private Integer parentId;

    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    private Integer type;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 图标
     */
    private String icon;

    /**
     * 状态：1有效；2删除
     */
    private Integer status;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    private Date updateTime;

    /**
     * 权限类型 1 存储 2列表 3系统警告 4 功能
     */
    private Integer permissionType;

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
     * 权限名称
     *
     * @return name 权限名称
     */
    public String getName() {
        return name;
    }

    /**
     * 权限名称
     *
     * @param name 权限名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 权限描述
     *
     * @return description 权限描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 权限描述
     *
     * @param description 权限描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 权限访问路径
     *
     * @return url 权限访问路径
     */
    public String getUrl() {
        return url;
    }

    /**
     * 权限访问路径
     *
     * @param url 权限访问路径
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 权限标识
     *
     * @return perms 权限标识
     */
    public String getPerms() {
        return perms;
    }

    /**
     * 权限标识
     *
     * @param perms 权限标识
     */
    public void setPerms(String perms) {
        this.perms = perms == null ? null : perms.trim();
    }

    /**
     * 父级权限id
     *
     * @return parent_id 父级权限id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 父级权限id
     *
     * @param parentId 父级权限id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 类型   0：目录   1：菜单   2：按钮
     *
     * @return type 类型   0：目录   1：菜单   2：按钮
     */
    public Integer getType() {
        return type;
    }

    /**
     * 类型   0：目录   1：菜单   2：按钮
     *
     * @param type 类型   0：目录   1：菜单   2：按钮
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 排序
     *
     * @return order_num 排序
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * 排序
     *
     * @param orderNum 排序
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 图标
     *
     * @return icon 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 图标
     *
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 状态：1有效；2删除
     *
     * @return status 状态：1有效；2删除
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态：1有效；2删除
     *
     * @param status 状态：1有效；2删除
     */
    public void setStatus(Integer status) {
        this.status = status;
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

    /**
     * 权限类型 1 存储 2列表 3系统警告 4 功能
     *
     * @return permission_type 权限类型 1 存储 2列表 3系统警告 4 功能
     */
    public Integer getPermissionType() {
        return permissionType;
    }

    /**
     * 权限类型 1 存储 2列表 3系统警告 4 功能
     *
     * @param permissionType 权限类型 1 存储 2列表 3系统警告 4 功能
     */
    public void setPermissionType(Integer permissionType) {
        this.permissionType = permissionType;
    }
}