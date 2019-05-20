package com.usa.zhiben.service.user;

import com.usa.zhiben.bean.web.user.User;

/**
 * @author 胖花
 * @create 2019-03-14 16:57
 */

public interface UserService {


    User getUserById(Integer userId);

    int addUser();

    void txTest();
}
