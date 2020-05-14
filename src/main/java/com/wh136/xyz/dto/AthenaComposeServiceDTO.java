package com.wh136.xyz.dto;


import lombok.Data;
import lombok.ToString;

import java.util.Map;
import java.util.Set;

@Data
@ToString
public class AthenaComposeServiceDTO {

    private String version;

    private Map<String, Object> services;

}

