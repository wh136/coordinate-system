package com.wh136.xyz.domain;

import javax.persistence.*;

@Entity
@Table(name="t_location")
public class Location {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String longitude; // 经度
    private String latitude;  //纬度
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }


}
