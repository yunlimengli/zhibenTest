package com.usa.zhiben.component.quartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @author 胖花
 * @create 2019-03-19 17:07
 */

public class MyCronJob extends QuartzJobBean {


    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("任务执行了" + new Date());
        // indexController.testMail();
    }
}