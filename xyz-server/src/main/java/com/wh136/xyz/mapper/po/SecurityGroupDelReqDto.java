package com.wh136.xyz.mapper.po;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author liulijing 00726
 * @version 1.0
 * @date 2019/11/8
 */
@Data
public class SecurityGroupDelReqDto {
    /**
     * id
     */
    @JsonProperty("ID")
    @NotNull(message = "ID不能为null")
    @Size(max = 64, message = "id最大长度不能超过64位。")
    private String instanceId;

    /**
     * 用户信息
     */
    @JsonProperty("TenantId")
    @NotNull(message = "用户信息信息不能为null")
    private String tenantId;

}
