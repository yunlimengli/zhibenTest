package com.usa.zhiben.bean.web.sysConfig;

import java.io.Serializable;

public class SysConfig implements Serializable {
    private Integer id;

    private Integer configType;

    private String configSubType;

    private String configName;

    private String configContent;

    private String memo;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConfigType() {
        return configType;
    }

    public void setConfigType(Integer configType) {
        this.configType = configType;
    }

    public String getConfigSubType() {
        return configSubType;
    }

    public void setConfigSubType(String configSubType) {
        this.configSubType = configSubType == null ? null : configSubType.trim();
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName == null ? null : configName.trim();
    }

    public String getConfigContent() {
        return configContent;
    }

    public void setConfigContent(String configContent) {
        this.configContent = configContent == null ? null : configContent.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", configType=").append(configType);
        sb.append(", configSubType=").append(configSubType);
        sb.append(", configName=").append(configName);
        sb.append(", configContent=").append(configContent);
        sb.append(", memo=").append(memo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}