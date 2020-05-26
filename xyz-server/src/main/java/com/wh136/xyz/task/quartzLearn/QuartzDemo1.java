package com.wh136.xyz.task.quartzLearn;

import com.wh136.xyz.task.quartzLearn.JobDemo.CronJob;
import com.wh136.xyz.task.quartzLearn.JobDemo.QuartzDemo1Job;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;
/*
*
* Quartz API的关键接口：
* Scheduler - 与调度程序交互的主要API。
* Job - 由希望由调度程序执行的组件实现的接口。
* JobDetail - 用于定义作业的实例。
* Trigger（即触发器） - 定义执行给定作业的计划的组件。
* JobBuilder - 用于定义/构建JobDetail实例，用于定义作业的实例。
* TriggerBuilder - 用于定义/构建触发器实例。
*
* Quartz提供的“builder”类,是一种领域特定语言（DSL，Domain Specific Language),提供级联的API
*
* */
@Slf4j
@Service
public class QuartzDemo1 implements ApplicationRunner {
    private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();
    /*
    * 使用StdSchedulerFactory获取的scheduer与@Resource注入的Scheduler是不同的！必须统一使用。为什么？待查资料
    * */

    @Resource
    CronJob cronJob;

    public void startDemo1 () {
        try {
            SchedulerFactory stdSchedulerFactory = new org.quartz.impl.StdSchedulerFactory();
            Scheduler scheduler = stdSchedulerFactory.getScheduler();
            scheduler.start();
            /*
            * scheduler实例化后，可以启动(start)、暂停(stand-by)、停止(shutdown)。
            * 注意：scheduler被停止后，除非重新实例化，否则不能重新启动；
            * 只有当scheduler启动后，(即使scheduler处于暂停状态也不行)trigger才会被触发（job才会被执行）。
            * */
            // define the job and tie it to our HelloJob class
            JobDetail jobDetail = newJob(QuartzDemo1Job.class)
                    .withIdentity("myJob", "group1")
                    .build();

            // Trigger the job to run now, and then every 40 seconds
            Trigger trigger = newTrigger()
                    .withIdentity("myTrigger", "group1")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInSeconds(3)
                            .repeatForever())
                    .build();

            // Tell quartz to schedule the job using our trigger
            scheduler.scheduleJob(jobDetail,trigger);
        } catch (SchedulerException e) {
            log.warn("executing job error ", e);
        }

    }

    public void startCronJob() {
        String executeTime = "30 57 12 * * ?"; // 12:57:30 开始出发
        try {
            SchedulerFactory stdSchedulerFactory = new org.quartz.impl.StdSchedulerFactory();
            Scheduler scheduler = stdSchedulerFactory.getScheduler();
            scheduler.start();

            JobDetail jobDetail = newJob(CronJob.class)
                    .withIdentity("myCronJob", "group1")
                    .build();

            // Trigger the job to run now, and then every 40 seconds
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("myCronTrigger", "group1")
                    .forJob("myCronJob", "group1")
                    .withSchedule(CronScheduleBuilder.cronSchedule(executeTime))
                    .build();
            // Tell quartz to schedule the job using our trigger
            scheduler.scheduleJob(jobDetail,trigger);
        } catch (Exception e) {
            log.info("error", e);
        }
    }
    public void editTrigger(String cronTime) {
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
//            scheduler.start();
            Trigger.TriggerState state = scheduler.getTriggerState(TriggerKey.triggerKey("myCronTrigger", "group1"));
//            scheduler.pauseTrigger(TriggerKey.triggerKey("myCronTrigger", "group1"));
//            scheduler.unscheduleJob(TriggerKey.triggerKey("myCronTrigger", "group1"));  // 这一行使Job和Trigger都没了
            log.info("trigger state: {} || job exists: {}", state.toString(),
                        scheduler.checkExists(JobKey.jobKey("myCronJob", "group1")));
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("myCronTrigger", "group1")
                    .forJob("myCronJob", "group1")
                    .withSchedule(CronScheduleBuilder.cronSchedule(cronTime))
                    .build();
            scheduler.rescheduleJob(TriggerKey.triggerKey("myCronTrigger", "group1"), trigger);
        } catch (Exception e) {
            log.info("edit ", e);
        }
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("app run begin");
        startCronJob();

        SchedulerFactory stdSchedulerFactory = new org.quartz.impl.StdSchedulerFactory();
        Scheduler scheduler = stdSchedulerFactory.getScheduler();
        Trigger.TriggerState state = scheduler.getTriggerState(TriggerKey.triggerKey("myCronTrigger", "group1"));

        log.info("cron job exist:{}", scheduler.checkExists(JobKey.jobKey("myCronJob", "group1")));
        log.info("cron trigger status:{}", state.toString());
    }
}
