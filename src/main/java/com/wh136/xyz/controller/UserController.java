package com.wh136.xyz.controller;

import com.alibaba.fastjson.JSONObject;
import com.wh136.xyz.common.model.AmapDTO;
import com.wh136.xyz.domain.User;
import com.wh136.xyz.service.UserService;
import com.wh136.xyz.task.quartzLearn.QuartzDemo1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class UserController {
    @Resource
    UserService userService;

    @Resource
    QuartzDemo1 quartzDemo1;

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
}
