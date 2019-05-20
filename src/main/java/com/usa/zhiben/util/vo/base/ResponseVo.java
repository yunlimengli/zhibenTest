package com.usa.zhiben.util.vo.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author superzheng
 * @version V1.0
 * @date 2018年7月11日
 */

@ApiModel(description = "返回响应数据")
public class ResponseVo<T> {
    @ApiModelProperty(value = "状态值")
    private Integer status;
    @ApiModelProperty(value = "返回提示信息")
    private String msg;
    @ApiModelProperty(value = "返回对象")
    private T data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseVo(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

}
