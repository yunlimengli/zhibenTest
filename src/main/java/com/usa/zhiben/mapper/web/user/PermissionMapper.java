package com.usa.zhiben.mapper.web.user;

import com.usa.zhiben.bean.web.user.Permission;
import com.usa.zhiben.bean.web.user.RolePermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper {
    /**
     * @mbg.generated 2019-03-21
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @mbg.generated 2019-03-21
     */
    int insert(Permission record);

    /**
     * @mbg.generated 2019-03-21
     */
    Permission selectByPrimaryKey(Integer id);

    /**
     * @mbg.generated 2019-03-21
     */
    List<Permission> selectAll();

    /**
     * @mbg.generated 2019-03-21
     */
    int updateByPrimaryKey(Permission record);

    List<RolePermission> selectRolePermission(Integer userId);
}