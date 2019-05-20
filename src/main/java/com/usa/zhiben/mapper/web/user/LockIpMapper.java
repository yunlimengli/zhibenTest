package com.usa.zhiben.mapper.web.user;

import com.usa.zhiben.bean.web.user.LockIp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface LockIpMapper {
    /**
     * @mbg.generated 2019-03-21
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @mbg.generated 2019-03-21
     */
    int insert(LockIp record);

    /**
     * @mbg.generated 2019-03-21
     */
    LockIp selectByPrimaryKey(Integer id);

    /**
     * @mbg.generated 2019-03-21
     */
    List<LockIp> selectAll();

    /**
     * @mbg.generated 2019-03-21
     */
    int updateByPrimaryKey(LockIp record);

    LockIp selectIp(String ipAddress);

}