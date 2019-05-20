package com.usa.zhiben.mapper.web.home;

import com.usa.zhiben.bean.web.home.DailyInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DailyInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DailyInfo record);

    DailyInfo selectByPrimaryKey(Integer id);

    List<DailyInfo> selectAll();

    int updateByPrimaryKey(DailyInfo record);


    /**
     * 查询该账户 订阅的每日资讯
     *
     * @param userId
     * @return
     */
    List<DailyInfo> getDailyInfoByUserId(@Param("userId") Integer userId);

    /**
     * 查询一般用户所拥有的每日资讯栏目
     *
     * @return
     */
    List<DailyInfo> selectDailyByUserLevel();

    /**
     * 根据userId 删除 用户 资讯中间表的信息
     *
     * @param userId
     * @return
     */
    int deleteMidDailyByUserId(@Param("userId") Integer userId);

    /**
     * 批量插入用户对应的每日资讯
     *
     * @param userId
     * @param dailyList
     * @return
     */
    int insertList(@Param("userId") Integer userId, @Param("list") List<Integer> dailyList);


}