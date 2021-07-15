package com.wh136.xyz.task;


import com.wh136.xyz.XyzApplication;
import com.wh136.xyz.task.quartzLearn.QuartzDemo1;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = XyzApplication.class)
@ActiveProfiles("dev")
@Slf4j
public class quartzDemo1Test {
    @Resource
    private QuartzDemo1 quartzDemo1;

    @Test
    public void testQuartz() {
        quartzDemo1.startDemo1();
        log.info("job exec finish");
    }
}
