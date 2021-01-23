package com.wh136.xyz.controller;


import com.wh136.xyz.task.utils.TaskMgr;
import lombok.extern.slf4j.Slf4j;
import netscape.javascript.JSObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/quartz")
@Slf4j
public class QuartzController {

    @Resource
    TaskMgr taskMgr;

    @RequestMapping(value = "/allJob", method = RequestMethod.GET)
    public JSObject getAllJobDetail() {
        taskMgr.printAllTaskInfo();
        return null;
    }

}
