package com.wh136.xyz.controller;


import com.wh136.xyz.common.concurrent.XyzExecutors;
import com.wh136.xyz.common.enumConst.ResourceType;
import com.wh136.xyz.common.response.RpcResult;
import com.wh136.xyz.common.util.SysUtils;
import com.wh136.xyz.mapper.po.BookPo;
import com.wh136.xyz.mapper.po.CleanUserAclPolicyPO;
import com.wh136.xyz.mapper.po.VpnClientClean;
import com.wh136.xyz.service.demo.DemoService;
import com.wh136.xyz.task.utils.TaskMgr;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/demo")
@Slf4j
public class DemoTestController {


    @Autowired
    TaskMgr taskMgr;
    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/transtest", method = RequestMethod.GET)
    public RpcResult<String> taskDiscard() {
        taskMgr.nonPublicCallTransaction();
        return new RpcResult<>();
    }


    @RequestMapping(value = "/tesetretu", method = RequestMethod.GET)
    public RpcResult<String> testre() {
        log.info("----->>{}", taskMgr.testReturn());
        return new RpcResult<>();
    }

    @PostMapping(value = "/insertbook")
    public RpcResult<String> insert(@RequestBody BookPo bookPo) {
        demoService.addBook(bookPo);
        return new RpcResult<>();
    }

    @GetMapping(value = "/zxc")
    public RpcResult<String> abc() {
        demoService.cleanslb();
        return new RpcResult<>();
    }

    @GetMapping(value = "/querytbl_lbaas_user_acl_policy")
    public RpcResult<CleanUserAclPolicyPO> querytbl_lbaas_user_acl_policy() {
        List<CleanUserAclPolicyPO> cleanUserAclPolicyPOS = demoService.querytbl_lbaas_user_acl_policy();
        RpcResult rpcResult = new RpcResult();
        rpcResult.setData(cleanUserAclPolicyPOS);
        return rpcResult;
    }


    @GetMapping(value = "/clean/vpnclient")
    public RpcResult<VpnClientClean> clientVpnClient() {
        List<VpnClientClean> vpnClientCleans = demoService.deleteVpnClient();
        RpcResult rpcResult = new RpcResult();
        rpcResult.setData(vpnClientCleans);
        return rpcResult;
    }


    @RequestMapping(value = "/taskDiscard", method = RequestMethod.GET)
    public RpcResult<String> taskDiscardaaa() {
        RpcResult rpcResult = new RpcResult();
        XyzExecutors.get().getDiscardService().execute(() -> SysUtils.workTime(1000));
        return rpcResult;
    }

    public static void main(String[] args) {
        System.out.println(ResourceType.PORTS.getType());
        System.out.println(ResourceType.PORT.getType());

        String uuid = "asdf-xcvc-eertdf";
        String uuid1 = "asdf-xcvc-eertdf";
        System.out.println(uuid.replace("-", ""));
        System.out.println(uuid1.replaceAll("-", ""));

        System.out.println(testReturn());


        String color = "blue";
        String name = "ishmael";

        List<String> strings = new ArrayList<String>();
        strings.add(color);
        strings.add(name);

//        if (strings.indexOf(color) > 0) {  // Noncompliant
//            // ...
//        }
//        if (name.indexOf("ish") > 0) { // Noncompliant
//            // ...
//        }
//        if (name.indexOf("ae") > 0) { // Noncompliant
//            // ...
//        }
//
//
//        if (strings.indexOf(color) > -1) {
//            // ...
//        }
//        if (name.indexOf("ish") >= 0) {
//            // ...
//        }
//        if (name.contains("ae")) {
//            // ...
//        }
        List<String> tsetstr = new ArrayList<>();
        tsetstr.add(reString());
        System.out.println(tsetstr);


    }

    private static Boolean testReturn() {
        return null;
    }

    private static String reString() {
        return null;
    }

}
