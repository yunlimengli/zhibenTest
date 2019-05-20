package com.usa.zhiben.component.quartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * 定时下载文件
 * @author 胖花
 * @create 2019-03-28 14:50
 */

public class FileDowmJob extends QuartzJobBean {


    @Autowired
    com.usa.zhiben.service.fileService.FileService fileService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        //定时想主web 获取需要下载的文件
        fileService.getDownFilePathFromWeb();


        System.out.println("任务获取下载计划  执行了" + new Date());
    }
}
