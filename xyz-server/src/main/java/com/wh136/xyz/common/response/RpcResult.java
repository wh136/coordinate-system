package com.wh136.xyz.common.response;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RpcResult<D> extends StateResult {

    private static final long serialVersionUID = -7515034298886151517L;

    private D data = null;

    public RpcResult() {
    }

    public RpcResult(String successMessage) {
        setState(SUCCESS);
        setSuccessMessage(successMessage);
    }

    public RpcResult(D data) {
        setData(data);
    }


}
