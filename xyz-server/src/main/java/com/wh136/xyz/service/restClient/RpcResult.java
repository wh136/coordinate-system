package com.wh136.xyz.service.restClient;

import java.io.Serializable;

/**
 * 接口返回结果
* */

public class RpcResult<D> implements Serializable {

    private static final long serialVersionUID = 1L;

    private D result;

    private Integer code;

    private String message;
}
