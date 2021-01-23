package com.wh136.xyz.dto;


import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
public class JobDetailDTO {

    private String jobName;

    private String groupName;

    private String previousFireTime;

    private String nextFireTime;

    private String info;

}
