package com.wh136.xyz.task.utils;

import com.wh136.xyz.dto.JobDetailDTO;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class TaskMgrImpl implements TaskMgr {

    @Resource
    Scheduler scheduler;


    @Override
    public List<JobDetailDTO> printAllTaskInfo() {
        try {
//            Scheduler scheduler = new StdSchedulerFactory().getScheduler();

            List<JobDetailDTO> jobDetailDTOList = new ArrayList<>();

            for (String groupName : scheduler.getJobGroupNames()) {
                for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {

                    String jobName = jobKey.getName();
                    String jobGroup = jobKey.getGroup();

                    List<Trigger> triggers = (List<Trigger>) scheduler.getTriggersOfJob(jobKey);
                    Date nextFireTime = triggers.get(0).getNextFireTime();
                    Date previousFireTime = triggers.get(0).getNextFireTime();
                    String previousTime = "";
                    String nextTime = "";
                    if (triggers.get(0).getPreviousFireTime() != null) {
                        previousTime  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(previousFireTime);
                    }
                    if (triggers.get(0).getNextFireTime() != null) {
                        nextTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(nextFireTime);
                    }
                    JobDetailDTO jobDetailDTO = new JobDetailDTO();
                    jobDetailDTO.setJobName(jobName);
                    jobDetailDTO.setGroupName(jobGroup);
                    jobDetailDTO.setNextFireTime(nextTime);
                    jobDetailDTO.setPreviousFireTime(previousTime);
                    jobDetailDTOList.add(jobDetailDTO);
                 }
            }
            return jobDetailDTOList;
        } catch (SchedulerException e) {
            log.info("[printAllTaskInfo]",e);
            return new ArrayList<>();
        }
    }
}
