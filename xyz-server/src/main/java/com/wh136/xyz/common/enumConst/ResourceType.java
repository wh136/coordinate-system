package com.wh136.xyz.common.enumConst;

public enum ResourceType {
    ROUTERS("ROUTERS"),
    SUBNETS("SUBNETS"),
    PORTS("PORTS"),
    PORT("port");

    ResourceType(String type) {
        this.type = type;
    }

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
