package com.usa.zhiben.component.interceptor;

import com.usa.zhiben.bean.web.user.User;
import com.usa.zhiben.service.sysConfigService.SysConfigService;
import com.usa.zhiben.util.vo.ResponseJson;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Set;

/**
 * @author 胖花
 * @create 2019-03-21 15:10
 */
@Component
public class FileAuthInterceptor implements HandlerInterceptor {

    @Autowired
    SysConfigService sysConfigService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        try {
            //1.判断是否登录
            HttpSession session = request.getSession();
            User userInfo = (User) session.getAttribute("userInfo");
            if (userInfo != null) {
                //2.判断访问的资源文件是否有权限
                Set<Long> fileIdSet = (Set<Long>) session.getAttribute("fileAuthList");
                if (fileIdSet != null) {
                    //获取参数
                    String idStr = request.getParameter("id");
                    if (!StringUtils.isBlank(idStr)) {
                        Long fid = Long.parseLong(idStr);
                        if (fileIdSet.contains(fid)) {
                            return true;
                        }
                    }

                }

            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        String file_not_auth = sysConfigService.getI18nMessageByKey("file_not_auth");
        ResponseJson.responseJsonInfo(response, "auth", file_not_auth);

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {


    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {


    }


}
