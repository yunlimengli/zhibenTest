package com.usa.zhiben.bean.web.home;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "DailyInfo对象", description = "每日资讯对象")
public class DailyInfo implements Serializable {

    private Integer id;
    @ApiModelProperty(value = "标识", name = "name", example = "cases_open")
    private String name;

    private Integer type;
    @ApiModelProperty(value = "页面展示的数据", name = "showName", example = "用户在线数量")
    private String showName;//页面展示的数据
    @ApiModelProperty(value = "是否拥订阅了此资讯 1是表示订阅了", name = "statu", example = "1")
    private int statu;//是否订阅了此资讯

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public int getStatu() {
        return statu;
    }

    public void setStatu(int statu) {
        this.statu = statu;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}