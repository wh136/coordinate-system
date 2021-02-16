package com.wh136.xyz.controller;


import com.wh136.xyz.common.concurrent.XyzExecutors;
import com.wh136.xyz.common.response.RpcResult;
import com.wh136.xyz.common.util.SysUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/public")
public class PublicController {

    @RequestMapping(value = "/taskDiscard", method = RequestMethod.GET)
    public RpcResult<String> taskDiscard() {
        RpcResult rpcResult = new RpcResult();
        XyzExecutors.get().getDiscardService().execute(()-> SysUtils.workTime(1000));
        return rpcResult;
    }

    @RequestMapping(value = "/taskReject", method = RequestMethod.GET)
    public RpcResult<String> taskReject() {
        RpcResult rpcResult = new RpcResult();
        XyzExecutors.get().getRejectService().execute(()-> SysUtils.workTime(20000));
        return rpcResult;
    }

}
