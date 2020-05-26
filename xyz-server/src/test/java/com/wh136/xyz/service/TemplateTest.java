package com.wh136.xyz.service;

import com.wh136.xyz.XyzApplication;
import com.wh136.xyz.service.templateMaker.TemplateMgr;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = XyzApplication.class)
@ActiveProfiles("dev")
@Slf4j
public class TemplateTest {

    @Resource
    private TemplateMgr templateMgr;

    @Test
    public void testTemplate() {
        templateMgr.replaceWordInFile();
    }
}
