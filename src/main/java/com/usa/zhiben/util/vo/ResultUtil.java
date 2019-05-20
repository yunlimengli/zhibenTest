package com.usa.zhiben.util.vo;


import com.usa.zhiben.util.vo.base.CoreConst;
import com.usa.zhiben.util.vo.base.PageResultVo;
import com.usa.zhiben.util.vo.base.ResponseVo;

import java.util.List;

/**
 * @author superzheng
 * @version V1.0
 * @date 2018年7月11日
 */
public class ResultUtil {

    public static ResponseVo success() {
        return vo(CoreConst.SUCCESS_CODE, null, null);
    }

    /**
     * 一般成功消息返回
     *
     * @param msg 返回的消息提示
     * @return
     */
    public static ResponseVo success(String msg) {
        return vo(CoreConst.SUCCESS_CODE, msg, null);
    }

    /**
     * 带数据的成功消息返回
     *
     * @param msg  返回的消息提示
     * @param data 携带的数据 可能是bean
     * @return
     */
    public static ResponseVo success(String msg, Object data) {
        return vo(CoreConst.SUCCESS_CODE, msg, data);
    }

    /**
     * 错误返回
     *
     * @return
     */
    public static ResponseVo error() {
        return vo(CoreConst.FAIL_CODE, null, null);
    }

    /**
     * 错误消息带提示返回
     *
     * @param msg
     * @return
     */
    public static ResponseVo error(String msg) {
        return vo(CoreConst.FAIL_CODE, msg, null);
    }

    public static ResponseVo error(String msg, Object data) {
        return vo(CoreConst.FAIL_CODE, msg, data);
    }

    /**
     * 返回表格数据 带总条数的
     *
     * @param list
     * @param total
     * @return
     */
    public static PageResultVo table(List<?> list, Long total) {
        return new PageResultVo(list, total);
    }

    public static ResponseVo vo(Integer status, String message, Object data) {
        return new ResponseVo<>(status, message, data);
    }


}
