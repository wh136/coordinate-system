package com.wh136.xyz.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Data
@ToString
public class AthenaServiceDTO {

    private String image;

    private String restart;

    private List<Map<String, String>> volumes;

}