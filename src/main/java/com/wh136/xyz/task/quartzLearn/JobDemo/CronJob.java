package com.wh136.xyz.task.quartzLearn.JobDemo;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class CronJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("run cron job。。。");
        try {
            Trigger trigger = jobExecutionContext.getTrigger();
            Scheduler scheduler = jobExecutionContext.getScheduler();
            log.info("trigger status: {}", scheduler.getTriggerState(trigger.getKey()));
        } catch (Exception e) {
            log.info("cron error", e);
        }
    }
}
