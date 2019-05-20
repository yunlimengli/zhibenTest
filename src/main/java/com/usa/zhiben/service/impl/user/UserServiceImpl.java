package com.usa.zhiben.service.impl.user;

import com.usa.zhiben.bean.sysLog.SysLog;
import com.usa.zhiben.bean.web.user.User;
import com.usa.zhiben.mapper.sysLog.SysLogMapper;
import com.usa.zhiben.mapper.web.user.UserMapper;
import com.usa.zhiben.service.log.SysLogService;
import com.usa.zhiben.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 胖花
 * @create 2019-03-14 18:36
 */
@Service
@Transactional(transactionManager = "xatx", propagation = Propagation.REQUIRED, rollbackFor = {RuntimeException.class})
public class UserServiceImpl implements UserService {


    @Autowired
    UserMapper userMapper;

    @Autowired
    SysLogMapper sysLogMapper;
    @Autowired
    SysLogService sysLogService;


    @Override
    public User getUserById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int addUser() {
        User user = new User();
        user.setFristName("sss");
        user.setLoginName("45sasas");
        user.setUserRole("dsdasfs");
        int insert = userMapper.insert(user);
        return insert;
    }

    //    @Transactional(transactionManager = "xatx", propagation = Propagation.REQUIRED, rollbackFor = { java.lang.RuntimeException.class })
    @Override
    public void txTest() {
        SysLog sysLog = new SysLog();
        sysLog.setLogEnevt("测试");
        sysLogMapper.insert(sysLog);

        User user = new User();

        user.setFristName("ssss");
        user.setLoginName("4511as");
        user.setUserRole("dsd123fs");
        int insert = userMapper.insert(user);

        int i = 1 / 0;
    }
}
