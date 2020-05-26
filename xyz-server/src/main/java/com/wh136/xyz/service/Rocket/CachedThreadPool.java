package com.wh136.xyz.service.Rocket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 使用执行器管理Thread
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();  // 为每一个任务都创建了一个线程
        for(int i = 0; i < 5; i++)
            exec.execute(new LiftOff());
        exec.shutdown(); // 防止新任务被提交给这个Executor
    }
}
