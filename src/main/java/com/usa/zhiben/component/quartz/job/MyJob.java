package com.usa.zhiben.component.quartz.job;

import com.usa.zhiben.service.mailService.MailService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;

/**
 * @author 胖花
 * @create 2019-03-19 17:06
 */

public class MyJob extends QuartzJobBean {

    @Autowired
    MailService mailService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("start My Job：" + LocalDateTime.now());
        try {
            String toMail = "981220083@qq.com";
            String sub = "这是测试邮件";
            String content = "asdsdzd13sz1f3dsf3zzxfvfsfd哈哈哈";
            mailService.sendHtmlMail(toMail, sub, content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("end  My Job：" + LocalDateTime.now());

    }
}