package com.usa.zhiben.mapper.web.sysConfig;

import com.usa.zhiben.bean.web.sysConfig.SysConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysConfig record);

    SysConfig selectByPrimaryKey(Integer id);

    List<SysConfig> selectAll();

    int updateByPrimaryKey(SysConfig record);

    /**
     * 根据配置分类 和配置名称 查询配置信息
     *
     * @param configType 配置分类
     * @param configName 配置名称
     * @return 返回配置信息
     */
    SysConfig selectByConfigName(@Param("configType") int configType, @Param("configName") String configName);

    /**
     * 更新除服务器设置以外的系统配置  服务器设置涉及多台服务器
     *
     * @param configType 配置分类
     * @param configName 配置名称
     * @param content    内容
     * @return
     */
    int updateSysConfigByConfigName(@Param("configType") int configType, @Param("configName") String configName, @Param("content") String content);
}