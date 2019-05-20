package com.usa.zhiben.mapper.sysLog;

import com.usa.zhiben.bean.sysLog.SysLog;

import java.util.List;

public interface SysLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysLog record);

    SysLog selectByPrimaryKey(Integer id);

    List<SysLog> selectAll();

    int updateByPrimaryKey(SysLog record);
}