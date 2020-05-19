package com.wh136.xyz.service.Rocket;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

@Slf4j
public class RocketMgrImpl implements RocketMgr{

    @Resource
    LiftOff liftOff;

    @Override
    public void liftOffRocket() {
        liftOff.run();
        // #0(9), #0(8), #0(7), #0(6), #0(5), #0(4), #0(3), #0(2), #0(1), #0(Liftoff!),
    }

    public static void main(String[] args) {  // main是一个线程
        LiftOff launch = new LiftOff();
        launch.run();  // 另外一个线程
    }
}
