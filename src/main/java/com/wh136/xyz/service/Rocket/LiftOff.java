package com.wh136.xyz.service.Rocket;

// 定义任务
public class LiftOff implements Runnable {
    protected int countDown = 10; // Default
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "Liftoff!") + "), ";
    }

    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            Thread.yield();
            /*
            * Thread.yield();
            * 告诉线程调度器，LiftOff已经执行完生命周期中最重要的部分，此时正是切换给其他任务执行一段时间的机会
            * yield：v. 出产（产品或作物）；产出（效果、收益等）；生息；屈服；放弃；停止争论；给（车辆）让路；（在外力、重压等下）屈曲
            * 在后面的其他例子中，将会看到yield产生的线程任务换进换出效果。
            * */
        }
    }
}
