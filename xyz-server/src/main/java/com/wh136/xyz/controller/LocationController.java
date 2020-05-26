package com.wh136.xyz.controller;

import com.wh136.xyz.common.model.AmapDTO;
import com.wh136.xyz.domain.Location;
import com.wh136.xyz.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/v3/geocode/geo")
    public AmapDTO getUser(@RequestParam(value = "address") String address,
                           @RequestParam(value = "output") String output,
                           @RequestParam(value = "key") String key) {
        Location location = locationService.getLongitudeLatitude(address);
        if (location != null) {
            String locationAddress = location.getLocation();
            Map<String, String> laObject= new HashMap();
            laObject.put("location", locationAddress);
            ArrayList<Object> listAddress = new ArrayList();
            listAddress.add(laObject);
            AmapDTO<Object> amapDTO = new AmapDTO();
            amapDTO.setCount("1");
            amapDTO.setGeocodes(listAddress);
            return amapDTO;
        } else {
            AmapDTO<Object> amapDTO = new AmapDTO();
            amapDTO.setCount("0");
            amapDTO.setGeocodes("address location do not exist, add first!");
            return amapDTO;
        }
    }
}
