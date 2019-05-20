package com.usa.zhiben.service.homeService;

import com.usa.zhiben.bean.web.home.DailyInfo;
import com.usa.zhiben.bean.web.home.MenuPanel;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author 胖花
 * @create 2019-03-21 17:38
 */
public interface HomeService {

    /**
     * 首页 获取 头的权限  每日资讯  面板信息
     *
     * @param request
     * @return
     */
    Map<String, Object> getHomeInfo(HttpServletRequest request) throws Exception;

    /**
     * 首页 获取每日资讯列表
     *
     * @param request
     * @return
     */
    List<DailyInfo> getAllDaily(HttpServletRequest request) throws Exception;

    /**
     * 更新每日资讯
     *
     * @param dailyList
     * @return
     * @throws Exception
     */
    int updateDaily(HttpServletRequest request, List<Integer> dailyList) throws Exception;


    /**
     * 获取所以的仪表盘信息
     *
     * @param request
     * @return
     */
    List<MenuPanel> getAllMenu(HttpServletRequest request) throws Exception;

    /**
     * 更新用户订阅的仪表盘信息
     *
     * @param request
     * @param panelList
     * @return
     */
    int updateMenuPanel(HttpServletRequest request, List<String> panelList);
}
