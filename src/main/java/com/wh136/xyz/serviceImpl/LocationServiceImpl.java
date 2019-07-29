package com.wh136.xyz.serviceImpl;

import com.wh136.xyz.dao.LocationRepository;
import com.wh136.xyz.domain.Location;
import com.wh136.xyz.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    LocationRepository locationRepository;

    @Override
    public Location getLongitudeLatitude(String address) {
         return  locationRepository.getLongitudeLatitude(address);
    }

    @Override
    public void setLongitudeLatitude(String address, String longitude, String latitude) {
//        Location location = new Location();
//        location.setAddress(address);
//        location.setLongitude(logitude);
//        location.setLatitude(latitude);
        locationRepository.setLongitudeLatitude(address, longitude, latitude);
    }
}
