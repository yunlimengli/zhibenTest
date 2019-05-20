package com.usa.zhiben.bean.web.home;

/**
 * @author 胖花
 * @create 2019-03-21 18:00
 */

public class HomeHeader {

    //展示的名称
    String headerName;
    //是否拥有此权限 1拥有
    int isAuth;
    //警报日志的数量
    int logCouts;

    public String getHeaderName() {
        return headerName;
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }

    public int getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(int isAuth) {
        this.isAuth = isAuth;
    }

    public int getLogCouts() {
        return logCouts;
    }

    public void setLogCouts(int logCouts) {
        this.logCouts = logCouts;
    }
}
