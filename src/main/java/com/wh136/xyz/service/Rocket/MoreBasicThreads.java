package com.wh136.xyz.service.Rocket;

// 使用debug观察线程行为，理解CPU时间片切分。查看线程的几种状态（Running,Zombie...)
public class MoreBasicThreads {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++)
            new Thread(new LiftOff()).start();  // start调用后，leftOff.run()被调用
        System.out.println("Waiting for LiftOff");
    }
}
