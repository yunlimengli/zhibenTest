package com.usa.zhiben.service.impl.homeServiceImpl;

import com.usa.zhiben.bean.web.home.DailyInfo;
import com.usa.zhiben.bean.web.home.MenuPanel;
import com.usa.zhiben.bean.web.user.User;
import com.usa.zhiben.mapper.web.home.DailyInfoMapper;
import com.usa.zhiben.mapper.web.home.MenuPanelMapper;
import com.usa.zhiben.service.homeService.HomeService;
import com.usa.zhiben.service.sysConfigService.SysConfigService;
import com.usa.zhiben.util.HttpUtils.HttpUtils;
import com.usa.zhiben.util.jsonUtils.FastJSONUtils;
import com.usa.zhiben.util.redisUtils.RedisUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页 相关的Service
 *
 * @author 胖花
 * @create 2019-03-21 18:12
 */
@Service
public class HomeServiceImpl implements HomeService {


    @Resource
    MenuPanelMapper menuPanelMapper;
    @Resource
    DailyInfoMapper dailyInfoMapper;
    @Autowired
    SysConfigService sysConfigService;

    @Autowired
    RedisUtil redisUtil;


    /**
     * 首页 获取 头的权限  每日资讯  面板信息
     *
     * @param request
     * @return
     */
    @Override
    public Map<String, Object> getHomeInfo(HttpServletRequest request) throws Exception {

        HttpSession session = request.getSession();
        if (session == null) {
            return null;
        }
        //此数据除了报警日志数量 其他的都是可以做缓存的
        Map<String, Object> parmMap = new HashMap<>();
        //从session 里取
        List<MenuPanel> listMenu = (List<MenuPanel>) session.getAttribute("seesion_menu");

        List<DailyInfo> listDaily = (List<DailyInfo>) session.getAttribute("seesion_daily");
        //1.获取 当前用户的id
        User user = HttpUtils.getSessionUser(request);
        Integer userId = 1;
        //Integer userId = user.getId();
        if (user == null) {
//            return  null;
        }
        //2.获取 5个头 headerAuth   当前用户设置的面板
        if (listMenu == null) {
            listMenu = menuPanelMapper.getMenuPanelByUserId(userId);
            //4.国际化
            for (MenuPanel menuPanel : listMenu) {
                String msg = sysConfigService.getI18nMessageByKey(menuPanel.getPanelName());
                menuPanel.setShowName(StringUtils.isBlank(msg) ? menuPanel.getPanelName() : msg);
            }
            session.setAttribute("seesion_menu", listMenu);
        }
        //3.获取每日资讯的栏目
        if (listDaily == null) {
            listDaily = dailyInfoMapper.getDailyInfoByUserId(userId);
            //4.国际化
            for (DailyInfo dailyInfo : listDaily) {
                String msg = sysConfigService.getI18nMessageByKey(dailyInfo.getName());
                dailyInfo.setShowName(StringUtils.isBlank(msg) ? dailyInfo.getName() : msg);
            }
            session.setAttribute("seesion_daily", listDaily);
        }

        //获取日志未处理数量
        String logCount = (String) redisUtil.get("not_handle_log_count");
        //如果为空要重新查询
        logCount = "150";
        parmMap.put("menu", listMenu);
        parmMap.put("daily", listDaily);
        parmMap.put("logCount", logCount);
        return parmMap;
    }

    /**
     * 首页 获取每日资讯列表
     *
     * @param request
     * @return
     */
    @Override
    public List<DailyInfo> getAllDaily(HttpServletRequest request) throws Exception {
        List<DailyInfo> list = null;
        //1.获取 当前用户的id
        User user = HttpUtils.getSessionUser(request);
        Integer userId = 1;
        int groupLevels = 1;
        //查询该用户是啥等级的
        //1.从redis 去取
        //管理员
        if (groupLevels != 3) {
            String allDailyStr = (String) redisUtil.get("menu_daily_all");
            if (StringUtils.isBlank(allDailyStr)) {
                //查数据库
                list = dailyInfoMapper.selectAll();
                //国际化
                for (DailyInfo dailyInfo : list) {
                    String msg = sysConfigService.getI18nMessageByKey(dailyInfo.getName());
                    dailyInfo.setShowName(StringUtils.isBlank(msg) ? dailyInfo.getName() : msg);
                }
                //设置进redis
                String jsonList = FastJSONUtils.toJSONS(list);
                redisUtil.set("menu_daily_all", jsonList);
            } else {
                //将str转为  List<DailyInfo>
                list = FastJSONUtils.toList(allDailyStr, DailyInfo.class);
            }
        } else {
            String userDailyStr = (String) redisUtil.get("menu_daily_user");
            if (StringUtils.isBlank(userDailyStr)) {
                //查数据库
                list = dailyInfoMapper.selectDailyByUserLevel();
                //国际化
                for (DailyInfo dailyInfo : list) {
                    String msg = sysConfigService.getI18nMessageByKey(dailyInfo.getName());
                    dailyInfo.setShowName(StringUtils.isBlank(msg) ? dailyInfo.getName() : msg);
                }
                //设置进redis
                String jsonList = FastJSONUtils.toJSONS(list);
                redisUtil.set("menu_daily_user", jsonList);
            } else {
                //将str转为  List<DailyInfo>
                list = FastJSONUtils.toList(userDailyStr, DailyInfo.class);
            }
        }
        return list;
    }

    /**
     * 更新每日资讯
     *
     * @param request
     * @param dailyList
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(transactionManager = "xatx", propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public int updateDaily(HttpServletRequest request, List<Integer> dailyList) throws Exception {

        //1.校验参数是否为空
        if (dailyList == null) {
            return 0;
        }
        //2.获取用户的iD
        //1.获取 当前用户的id
        User user = HttpUtils.getSessionUser(request);
        Integer userId = 2;
        //3.移除该用户的所以订阅的消息
        int deleteStatus = dailyInfoMapper.deleteMidDailyByUserId(userId);
        //批量插入
        if (dailyList.size() > 0) {
            int insertStatus = dailyInfoMapper.insertList(userId, dailyList);
        }
        //更新完订阅的每日资讯 要清除sessioN保存的每日资讯信息
        request.getSession().removeAttribute("seesion_daily");

        return 1;
    }

    /**
     * 获取所以的仪表盘信息
     *
     * @param request
     * @return
     */
    @Override
    public List<MenuPanel> getAllMenu(HttpServletRequest request) throws Exception {

        List<MenuPanel> list = null;
        //1.获取 当前用户的id
        User user = HttpUtils.getSessionUser(request);
        Integer userId = 1;
        int groupLevels = 1;
        //查询该用户是啥等级的
        //1.从redis 去取
        //管理员
        if (groupLevels != 3) {
            String allMenuPanelStrStr = (String) redisUtil.get("menu_daily_all");
            if (StringUtils.isBlank(allMenuPanelStrStr)) {
                //查数据库
                list = menuPanelMapper.selectAllPanel();
                //国际化
                for (MenuPanel menuPanel : list) {
                    String msg = sysConfigService.getI18nMessageByKey(menuPanel.getPanelName());
                    menuPanel.setShowName(StringUtils.isBlank(msg) ? menuPanel.getPanelName() : msg);
                }
                //设置进redis
                String jsonList = FastJSONUtils.toJSONS(list);
                redisUtil.set("menu_daily_all", jsonList);
            } else {
                //将str转为  List<DailyInfo>
                list = FastJSONUtils.toList(allMenuPanelStrStr, MenuPanel.class);
            }
        } else {
            String menuPanelStr = (String) redisUtil.get("menu_daily_user");
            if (StringUtils.isBlank(menuPanelStr)) {
                //查数据库
                list = menuPanelMapper.selectUserPanel();
                //国际化
                for (MenuPanel menuPanel : list) {
                    String msg = sysConfigService.getI18nMessageByKey(menuPanel.getPanelName());
                    menuPanel.setShowName(StringUtils.isBlank(msg) ? menuPanel.getPanelName() : msg);
                }
                //设置进redis
                String jsonList = FastJSONUtils.toJSONS(list);
                redisUtil.set("menu_daily_user", jsonList);
            } else {
                //将str转为  List<DailyInfo>
                list = FastJSONUtils.toList(menuPanelStr, MenuPanel.class);
            }
        }
        return list;
    }

    /**
     * 更新用户订阅的仪表盘信息
     *
     * @param request
     * @param panelList
     * @return
     */
    @Override
    @Transactional(transactionManager = "xatx", propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public int updateMenuPanel(HttpServletRequest request, List<String> panelList) {
        //1.校验参数是否为空
        if (panelList == null) {
            return 0;
        }
        if (panelList.size() > 4) {
            return -1;
        }
        //2.获取用户的iD
        //1.获取 当前用户的id
        User user = HttpUtils.getSessionUser(request);
        Integer userId = 2;
        //3.移除该用户的所以订阅的消息
        //查询 该用户所 有的 file live  setting 权限
        List<String> menuPanelByUserId = menuPanelMapper.getMidMenuPanelByUserId(userId);
        //删除中间表
        int deleteStatus = menuPanelMapper.deleteMidDailyByUserId(userId);
        //把刚查出来的 menuPanelByUserId 重新插入
        menuPanelMapper.insertList(userId, menuPanelByUserId);
        //批量插入
        if (panelList.size() > 0) {
            int insertStatus = menuPanelMapper.insertList(userId, panelList);
        }
        //更新完订阅的每日资讯 要清除sessioN保存的每日资讯信息
        request.getSession().removeAttribute("seesion_daily");
        return 1;
    }
}
