package com.wh136.xyz.common.model;

public class AmapDTO<T> {
    private String status;
    private String info;
    private String infocode;
    private String count;

    private T geocodes;

//    public enum Result {
//        SUCCESS, FAILURE, PARTIAL_SUCCESS
//    }

    public AmapDTO() {
    }

    public AmapDTO(T geocodes) {
        this.status = "1";
        this.info = "OK";
        this.infocode = "10000";
        if (geocodes == null) {
            this.count = "0";
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfocode() {
        return infocode;
    }

    public void setInfocode(String infocode) {
        this.infocode = infocode;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public T getGeocodes() {
        return geocodes;
    }

    public void setGeocodes(T geocodes) {
        this.geocodes = geocodes;
    }

}
