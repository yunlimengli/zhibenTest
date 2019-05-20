package com.usa.zhiben.service.user;

import com.usa.zhiben.bean.web.user.RolePermission;
import com.usa.zhiben.bean.web.user.User;

import java.util.List;

public interface LoginService {
    /**
     * 查询用户
     *
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 通过角色id 查询所有权限
     *
     * @param userId
     * @return
     */
    List<RolePermission> findPermissionById(Integer userId);

    /**
     * 查询IP是否在锁定表中,返回true 和false
     */
    boolean findLockIp(String ipAddress);


}
