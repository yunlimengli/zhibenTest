package com.usa.zhiben.mapper.web.user;

import com.usa.zhiben.bean.web.user.Group;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GroupMapper {
    /**
     * @mbg.generated 2019-03-21
     */
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("groupName") String groupName);

    /**
     * @mbg.generated 2019-03-21
     */
    int insert(Group record);

    /**
     * @mbg.generated 2019-03-21
     */
    Group selectByPrimaryKey(@Param("id") Integer id, @Param("groupName") String groupName);

    /**
     * @mbg.generated 2019-03-21
     */
    List<Group> selectAll();

    /**
     * @mbg.generated 2019-03-21
     */
    int updateByPrimaryKey(Group record);
}