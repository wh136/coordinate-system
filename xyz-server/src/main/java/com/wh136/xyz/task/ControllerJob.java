package com.wh136.xyz.task;


import com.wh136.xyz.common.concurrent.XyzExecutors;
import com.wh136.xyz.common.util.SysUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 * */

@Component
@Slf4j
public class ControllerJob {

//    @Scheduled(cron = "0/2 * * * * ? ")
//    public void cronDiscardTask() {
//        log.info("[cronDiscardTask] begin");
//        XyzExecutors.get().getDiscardService().execute(()-> SysUtils.workTime(40000));
//        log.info("[cronDiscardTask] end");
//    }


//    @Scheduled(cron = "0/1 * * * * ? ")
//    public void cronBigQueueDiscardTask() {
//        log.info("[cronDiscardTask] begin");
//        XyzExecutors.get().getDiscardService().execute(()-> SysUtils.workTime(40000));
//        log.info("[cronDiscardTask] end");
//    }
}
