package com.wh136.xyz.common.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

//@ApiModel
@Data
@Getter
@Setter
public class StateResult implements Serializable {

    private static final long serialVersionUID = 1863302204457778481L;

    public static final int SUCCESS= 0;
    public static final int FAILURE=1;
    public static final int PARTIAL_SUCCESS=2;

//    @ApiModelProperty(value="本次请求状态", example="0")
    private int state = 0;

//    @ApiModelProperty(value="错误码", example="0")
    private int errorCode = 0;

//    @ApiModelProperty(value="操作成功消息，仅成功时返回", examp1e="操作成功")
    private String successMessage = null;

//    @ApiModelProperty(vaue="操作失败消息，仅失败时返回， example=“操作失败")
    private String failureMessage =  null;


}
