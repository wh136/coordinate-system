package com.wh136.xyz.common.ssh;

import lombok.Data;
import lombok.ToString;

/**
* ssh远程主机类
* */


@Data
@ToString
public class SSHHost {

    private String ip;

    private String user;

    private String password;

    private Integer port;
}
