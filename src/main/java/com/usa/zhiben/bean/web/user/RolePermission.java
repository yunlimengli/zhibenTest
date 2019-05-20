package com.usa.zhiben.bean.web.user;

/**
 * @author jlh
 * *     " 三里清风三里路，步步清风再无心。"
 * @date 2019/3/20 17:06
 * *   角色对应的权限
 */
public class RolePermission {

    private String name; //权限名称
    private String perms;  //权限标识
    private Integer permissionId; // 权限id
    private Integer groupId;  //角色ID


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
                "name='" + name + '\'' +
                ", perms='" + perms + '\'' +
                ", permissionId=" + permissionId +
                ", groupId=" + groupId +
                '}';
    }

}
