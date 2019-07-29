package com.wh136.xyz.controller;

import com.wh136.xyz.domain.Location;
import com.wh136.xyz.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationController {
    @Autowired
    LocationService locationService;

    // @RequestBody哪里建议使用DTO类，并且DTO为Entity要实现Serializable
    @PostMapping("/v3/geocode/geo")
    public String addAddress(@RequestBody Location locationList) {
        // 未进行字段校验，如果key拼错，导致数据库插入数据不完整
        String address = locationList.getAddress();
        if(locationService.getLongitudeLatitude(address)==null){
            String latitude = locationList.getLatitude();
            String longtitude = locationList.getLongitude();
            locationService.setLongitudeLatitude(address, longtitude, latitude);
            return "insert ok";
        } else {
            return "address already exist!";
        }
    }
}
