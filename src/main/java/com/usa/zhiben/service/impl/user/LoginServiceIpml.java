package com.usa.zhiben.service.impl.user;

import com.usa.zhiben.bean.web.user.LockIp;
import com.usa.zhiben.bean.web.user.RolePermission;
import com.usa.zhiben.bean.web.user.User;
import com.usa.zhiben.mapper.web.user.LockIpMapper;
import com.usa.zhiben.mapper.web.user.PermissionMapper;
import com.usa.zhiben.mapper.web.user.UserMapper;

import com.usa.zhiben.service.user.LoginService;
import com.usa.zhiben.util.DDLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jlh
 * *     " 三里清风三里路，步步清风再无心。"
 * @date 2019/3/15 10:47
 * *
 */
@Service
public class LoginServiceIpml implements LoginService {
    @Resource
    UserMapper userMapper;
    @Resource
    PermissionMapper permission;
    @Resource
    LockIpMapper lockIpMapper;

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public User findByUsername(String username) {
        try {
            User user = userMapper.selectName(username);
            String aaa = user.toString();
            DDLog.infoFormat("TbUser", aaa);
            // 具体使用
//			stringRedisTemplate.opsForValue().set(user.getLoginName(), JsonUtil.objectToJSONString(user));
            return user;
//		stringRedisTemplate.opsForValue().set("user:lastName", "张三");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    @Override
    public List<RolePermission> findPermissionById(Integer userId) {
        List<RolePermission> list = permission.selectRolePermission(userId);
        DDLog.info(list.toString());
        redisTemplate.opsForList().leftPush("" + userId, list);
        return list;
    }

    @Override
    public boolean findLockIp(String ipAddress) {
        LockIp lockIp = null;
        try {
            lockIp = lockIpMapper.selectIp(ipAddress);
            if (lockIp == null) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
