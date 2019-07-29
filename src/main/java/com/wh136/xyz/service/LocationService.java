package com.wh136.xyz.service;

import com.wh136.xyz.domain.Location;

public interface LocationService {
    Location getLongitudeLatitude(String address);
    void setLongitudeLatitude(String address, String longitude, String latitude);
}
