package com.usa.zhiben.mapper.web.user;

import com.usa.zhiben.bean.web.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * @mbg.generated 2019-03-21
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @mbg.generated 2019-03-21
     */
    int insert(User record);

    /**
     * @mbg.generated 2019-03-21
     */
    User selectByPrimaryKey(Integer id);

    /**
     * @mbg.generated 2019-03-21
     */
    List<User> selectAll();

    /**
     * @mbg.generated 2019-03-21
     */
    int updateByPrimaryKey(User record);


    User selectName(String name);
}