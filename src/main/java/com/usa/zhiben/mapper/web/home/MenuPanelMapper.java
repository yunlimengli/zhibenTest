package com.usa.zhiben.mapper.web.home;

import com.usa.zhiben.bean.web.home.MenuPanel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuPanelMapper {

    int deleteByPrimaryKey(@Param("id") Integer id, @Param("panelNo") String panelNo);

    int insert(MenuPanel record);

    MenuPanel selectByPrimaryKey(@Param("id") Integer id, @Param("panelNo") String panelNo);

    List<MenuPanel> selectAll();

    int updateByPrimaryKey(MenuPanel record);

    /**
     * 根据人员编号查询 面板
     *
     * @param userId
     * @return
     */
    List<MenuPanel> getMenuPanelByUserId(@Param(("userId")) Integer userId);

    /**
     * 查询管理员 能设置的仪表盘  因为这个表包含 头的一些权限 所以要注意
     *
     * @return
     */
    List<MenuPanel> selectAllPanel();

    /**
     * 查询一般人员所能看到一般仪表盘
     *
     * @return
     */
    List<MenuPanel> selectUserPanel();

    /**
     * 移除该用户订阅的仪表盘
     *
     * @param userId
     * @return
     */
    int deleteMidDailyByUserId(@Param(("userId")) Integer userId);

    /**
     * 批量插入用户设置的仪表盘信息
     *
     * @param userId
     * @param panelList
     * @return
     */
    int insertList(@Param(("userId")) Integer userId, @Param(("list")) List<String> panelList);

    /**
     * 查询该账户 user panel  中间表的  头的权限  file  live ..
     *
     * @param userId
     * @return
     */
    List<String> getMidMenuPanelByUserId(@Param(("userId")) Integer userId);
}