package com.wh136.xyz.domain;

import javax.persistence.*;

@Entity
@Table(name="t_location")
public class Location {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String address;
    private String longitude; // 经度
    private String latitude;  //纬度

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
    //   兰州:东经103°49′,北纬36°03   经度范围 -180° ~ 180度  纬度 -90° ~90°
    public String getLocation() {
        return this.longitude+","+this.latitude;
    }

}
