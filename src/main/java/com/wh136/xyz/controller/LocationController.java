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

    @PostMapping
    public String addAddress(@RequestBody List<Location> locationList) {
        locationService.setLongitudeLatitude(locationList);
    }
}
