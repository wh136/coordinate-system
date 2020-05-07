package com.wh136.xyz.task.quartzLearn;

import com.wh136.xyz.task.quartzLearn.JobDemo.QuartzDemo1Job;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.*;
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
public class QuartzDemo1 {



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
}
