package com.usa.zhiben.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jlh
 * *     " 三里清风三里路，步步清风再无心。"
 * @date 2018/12/18 10:48
 * *       线程日志打印工具类
 */
public class DDLog {

    private static Logger log = LoggerFactory.getLogger(DDLog.class);

    private static final int INFO = 1;
    private static final int DEBUG = 2;
    private static final int ERROR = 3;
    private static final int level = ERROR;
    private static final String DOU = "---DUDU----: ";

    public static void info(String msg) {
        if (INFO <= level) {
            log.info(DOU + msg);
        }
    }

    public static void info(String tag, String msg) {
        if (INFO <= level) {
            log.info(DOU + tag + ":" + msg);
        }
    }

    public static void infoFormat(String format, Object... arguments) {
        if (INFO <= level) {
            log.info(DOU, format, arguments);
        }
    }

    public static void infoFormat(String format, String msg) {
        if (INFO <= level) {
            log.info(format, DOU + msg);
        }
    }


    public static void debug(String msg) {
        if (DEBUG <= level) {
            log.debug(DOU + msg);
        }
    }

    public static void debug(String tag, String msg) {
        if (DEBUG <= level) {
            log.debug(DOU + tag + ":" + msg);
        }
    }

    public static void debugFormat(String format, String msg) {
        if (DEBUG <= level) {
            log.debug(format, DOU + msg);
        }
    }

    public static void error(String msg) {
        if (ERROR <= level) {
            log.error(DOU + msg);
        }
    }

    public static void error(String tag, String msg) {
        if (ERROR <= level) {
            log.error(DOU + tag + ":" + msg);
        }
    }

    public static void errorFormat(String format, Object... arguments) {
        if (ERROR <= level) {
            log.error(DOU, format, arguments);
        }
    }

    public static void errorFormat(String format, String msg) {
        if (ERROR <= level) {
            log.error(format, DOU + msg);
        }
    }


}
