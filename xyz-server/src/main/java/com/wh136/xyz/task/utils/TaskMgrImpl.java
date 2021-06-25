package com.wh136.xyz.task.utils;

import com.wh136.xyz.dao.BookRepository;
import com.wh136.xyz.dto.JobDetailDTO;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
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


    @Autowired
    BookRepository bookRepository;


    @Autowired
    TaskMgrImpl taskMgr;

    @Override
    public void nonPublicCallTransaction() {
        taskMgr.protectTransaction();
    }


    @Override
    @Transactional(rollbackOn = Exception.class)
    public void protectTransaction() {
        bookRepository.setbookname("book1");
        int error = 1 / 0;
    }

    @Override
    public int testReturn() {
        try {
            int a = 1 / 0;
            return 2;
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
        return 1;
    }
}
