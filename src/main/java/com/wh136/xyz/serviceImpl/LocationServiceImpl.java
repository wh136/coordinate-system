package com.wh136.xyz.serviceImpl;

import com.wh136.xyz.dao.LocationRepository;
import com.wh136.xyz.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    LocationRepository locationRepository;

    @Override
    public String getLongitudeLatitude(String address) {
         return  locationRepository.getLongitudeLatitude(address);
    }

    @Override
    public String setLongitudeLatitude(String address, String logitude, String latitude) {

        locationRepository
    }
}
