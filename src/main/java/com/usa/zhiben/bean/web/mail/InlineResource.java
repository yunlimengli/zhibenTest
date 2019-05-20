package com.usa.zhiben.bean.web.mail;

/**
 * @author 胖花
 * @create 2019-03-19 15:00
 */

public class InlineResource {

    private String cid;
    private String path;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public InlineResource(String cid, String path) {
        super();
        this.cid = cid;
        this.path = path;
    }

}
