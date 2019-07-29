package com.wh136.xyz.service;

public interface LocationService {
    public String getLongitudeLatitude(String address);
    public String setLongitudeLatitude(String address, String logitude, String latitude);
}
