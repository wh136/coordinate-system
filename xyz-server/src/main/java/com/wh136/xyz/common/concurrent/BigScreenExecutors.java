package com.wh136.xyz.common.concurrent;

public class BigScreenExecutors extends XyzExecutors {

    private static final BigScreenExecutors instance = new BigScreenExecutors();

    /** 默认的核心线程数*/
    private static final int THREAD_CORE = 6;

    /** 默认的最大线程数*/
    private static final int THREAD_MAX = 12;

    /** 默认的空闲间隔*/
    private static final int THREAD_IDLE = 30;

    /** 默认的队列大小*/
    private static final int THREAD_CAPACITY = 1024;
}
