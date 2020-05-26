package com.wh136.xyz.controller;

import com.alibaba.fastjson.JSONObject;
import com.wh136.xyz.common.model.AmapDTO;
import com.wh136.xyz.domain.User;
import com.wh136.xyz.service.UserService;
import com.wh136.xyz.service.templateMaker.TemplateMgr;
import com.wh136.xyz.task.quartzLearn.QuartzDemo1;
import jdk.nashorn.internal.scripts.JO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class UserController {
    @Resource
    UserService userService;

    @Resource
    QuartzDemo1 quartzDemo1;

    @Resource
    TemplateMgr templateMgr;

    @RequestMapping("/getUser/{id}")
    public AmapDTO getUser(@PathVariable("id") Integer id) {
        AmapDTO amapDTO = new AmapDTO();
        amapDTO.setGeocodes(userService.getUser(id));
        return amapDTO;
    }

    @RequestMapping("/quartz")
    public JSONObject getQuartz() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key1", "value");
        log.info("get info");
        quartzDemo1.startDemo1();
        return jsonObject;
    }

    @PostMapping("/quartz")
    public JSONObject setCronTime(@RequestBody JSONObject jsonObject) {
        log.info(jsonObject.toJSONString());
        quartzDemo1.editTrigger(jsonObject.get("cronTime").toString());
        jsonObject.put("state", "got OK");
        return jsonObject;
    }

    @GetMapping(value = "/test")
    public JSONObject testTemplate() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key1", "value");
        templateMgr.replaceWordInFile();
        return jsonObject;
    }
}
