package com.wh136.xyz.service.Rocket;

// Thread类，以下代码产生两个线程（main线程和LiftOff线程)
public class BasicThreads {
    public static void main(String[] args) {  // main是一个线程
        Thread t = new Thread(new LiftOff());  // 需要一个Runnable对象，来产生一个线程
        t.start(); // 立即返回， liftOff.run()是由其他线程执行，而底下的打印操作是由main线程执行。（用Idea的debug可以看到不同的效果）
        System.out.println("Waiting for LiftOff");
    }
}  // Output: (90% match)
