package com.usa.zhiben.config.quartzConfig;

import com.usa.zhiben.component.quartz.job.FileDowmJob;
import com.usa.zhiben.component.quartz.job.MyJob;
import com.usa.zhiben.component.quartz.job.WebSocketJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 定时器配置类
 *
 * @author 胖花
 * @create 2019-03-19 17:09
 */
@Configuration
public class QuartzConfiguration {


    // 使用jobDetail包装job
//    @Bean
    public JobDetail myJobDetail() {
        return JobBuilder.newJob(MyJob.class).withIdentity("myJob").storeDurably().build();
    }

    // 把jobDetail注册到trigger上去
//    @Bean
    public Trigger myJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(5).repeatForever();

        return TriggerBuilder.newTrigger()
                .forJob(myJobDetail())
                .withIdentity("myJobTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }


    //获取文件下载数据----------------------------------------------------------------------------------

    @Bean
    public JobDetail fileDowmJobDetail() {
        return JobBuilder.newJob(FileDowmJob.class).withIdentity("fileDowmJob").storeDurably().build();
    }

    @Bean
    public Trigger fileDowmTrigger() {

//        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0 0/1 * * * ?");
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");

        return TriggerBuilder.newTrigger()
                .forJob(fileDowmJobDetail())
                .withIdentity("fileDowmTrigger")
                .withSchedule(cronScheduleBuilder)
                .build();
    }

    //获取文件下载数据----------------------------------------------------------------------------------


    /* -------------------------------------------websocket重连定时器----------------------------------------- */
    // 使用jobDetail包装job
    @Bean
    public JobDetail myCronJobDetailSocket() {
        return JobBuilder.newJob(WebSocketJob.class).withIdentity("myCronJobSocket").storeDurably().build();
    }

    // 把jobDetail注册到Cron表达式的trigger上去
    @Bean
    public Trigger CronJobTriggerSocket() {

        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
//        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/10 * * * * ?");

        return TriggerBuilder.newTrigger()
                .forJob(myCronJobDetailSocket())
                .withIdentity("myCronJobTriggerSocket")
                .withSchedule(cronScheduleBuilder)
                .build();
    }

    /* -------------------------------------------websocket重连定时器----------------------------------------- */


}
