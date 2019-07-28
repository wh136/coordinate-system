package com.wh136.xyz.controller;

import com.wh136.xyz.common.model.AmapDTO;
import com.wh136.xyz.domain.User;
import com.wh136.xyz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        AmapDTO amapDTO = new AmapDTO();
        return amapDTO.setGeocodes(userService.getUser(id));
    }
}
