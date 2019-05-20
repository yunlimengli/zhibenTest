package com.usa.zhiben.bean.web.home;

import java.io.Serializable;

public class MenuPanel implements Serializable {


    private Integer id;

    private String panelNo;

    private String panelName;

    private Integer panelType;

    private String showName;//展示在页面上的名称  国际化

    private int statu;//是否拥有此权限

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPanelNo() {
        return panelNo;
    }

    public void setPanelNo(String panelNo) {
        this.panelNo = panelNo == null ? null : panelNo.trim();
    }

    public String getPanelName() {
        return panelName;
    }

    public void setPanelName(String panelName) {
        this.panelName = panelName == null ? null : panelName.trim();
    }

    public Integer getPanelType() {
        return panelType;
    }

    public void setPanelType(Integer panelType) {
        this.panelType = panelType;
    }

    public int getStatu() {
        return statu;
    }

    public void setStatu(int statu) {
        this.statu = statu;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", panelNo=").append(panelNo);
        sb.append(", panelName=").append(panelName);
        sb.append(", panelType=").append(panelType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}