package com.wh136.xyz.task.quartzLearn.JobDemo;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.Scheduler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service("quartzDemo1Job")
public class QuartzDemo1Job implements Job {



    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Trigger trigger = jobExecutionContext.getTrigger();
        Scheduler scheduler = jobExecutionContext.getScheduler();
        try {
            JobDetail jobDetail = scheduler.getJobDetail(JobKey.jobKey("myjob", "group1"));
            Trigger.TriggerState state = scheduler.getTriggerState(TriggerKey.triggerKey("myCronTrigger", "group1"));

            log.info("Listening... || cron job exist:{} || cron trigger status:{}",
                    scheduler.checkExists(JobKey.jobKey("myCronJob", "group1")),
                    state.toString());
        } catch (Exception e) {
            log.info("get trigger err ", e);
        }
        /* job状态
        * WAITING:等待
        * PAUSED:暂停
        * ACQUIRED:正常执行
        * BLOCKED：阻塞
        * ERROR：错误
        * */

        /*** trigger 状态
         * STATE_BLOCKED 4 阻塞
            STATE_COMPLETE 2 完成
            STATE_ERROR 3 错误
            STATE_NONE -1 不存在
            STATE_NORMAL 0 正常
            STATE_PAUSED 1 暂停
        ***/

    }
}
