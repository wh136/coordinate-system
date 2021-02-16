package com.wh136.xyz.common.concurrent;

import com.alibaba.druid.util.DaemonThreadFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
*  执行任务的线程池
* */

@Slf4j
public class XyzExecutors {
    private static final XyzExecutors instance = new XyzExecutors();

    /** 默认的核心线程数*/
    private static final int THREAD_CORE = 6;

    /** 默认的最大线程数*/
    private static final int THREAD_MAX = 12;

    /** 默认的空闲间隔*/
    private static final int THREAD_IDLE = 30;

    /** 默认的队列大小*/
    private static final int THREAD_CAPACITY = 1024;

    public static XyzExecutors get() {
        return instance;
    }
    /** 公共事件线程池（异步入库、异步方法执行等*/
    private static ExecutorService commonService = null;

    /** 处理RabbitMQ消息的小城池*/
    private static ExecutorService rabbitMQService = null;

    // 公共线程池
    private volatile ExecutorService publicService = null;
    /** 任务丢弃式线程池*/
    private volatile ExecutorService discardService = null;
    /**任务丢弃式线程池*/
    private volatile ExecutorService noDiscardService = null;
    /**任务拒绝式线程池*/
    private volatile ExecutorService rejectService = null;
    /***/

    static {
        commonService = new ThreadPoolExecutor(THREAD_CORE,
                THREAD_MAX, THREAD_IDLE, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(THREAD_CAPACITY),
                new DaemonThreadFactory("WebCommonOperateService"),
                new RejectExecutionHandlerImpl());

        rabbitMQService = new ThreadPoolExecutor(THREAD_CORE,
                THREAD_MAX, THREAD_IDLE, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(THREAD_CAPACITY),
                new DaemonThreadFactory("WebRabbitMQService"),
                new RejectExecutionHandlerImpl());
    }

    public ExecutorService getCommonService() {
        return commonService;
    }

    public ExecutorService getRabbitMQService() {
        return rabbitMQService;
    }

    public void destroy() {
        // 主动释放线程池资源，避免资源泄露
        shutdownService(commonService);
    }

    private void shutdownService(ExecutorService service) {
        if (service == null) {
            return;
        }
        try {
            List<Runnable> awaiting = service.shutdownNow();
            if (!CollectionUtils.isEmpty(awaiting)) {
                String threadNames = Arrays.toString(awaiting.toArray(new Runnable[awaiting.size()]));
                log.info("shutdown awating task:{}", threadNames);
            }
        } catch (Exception e) {
            log.info("shutdown executorservice", e);
        }
    }

    public ExecutorService getPublicService() {
        if (null == this.publicService) {
            synchronized (this) {
                if (null == this.publicService) {
                    publicService = new ThreadPoolExecutor(24, 512, THREAD_IDLE, TimeUnit.SECONDS,
                            new LinkedBlockingQueue<>(THREAD_CAPACITY),
                            new DaemonThreadFactory("publicService"),
                            new ThreadPoolExecutor.DiscardPolicy());
                }
            }
        }
        return publicService;
    }

    public ExecutorService getDiscardService() {
        if (null == this.discardService) {
            synchronized (this) {
                if (null == this.discardService) {
                    discardService = new ThreadPoolExecutor(1, 2, THREAD_IDLE, TimeUnit.SECONDS,
                            new LinkedBlockingQueue<>(2),
                            new DaemonThreadFactory("disCardService"),
                            new XyzDiscardPolicy());
                }
            }
        }
        return discardService;
    }

    public ExecutorService getNoDiscardService() {
        if (null == this.publicService) {
            synchronized (this) {
                if (null == this.publicService) {
                    publicService = new ThreadPoolExecutor(1, 2, THREAD_IDLE, TimeUnit.SECONDS,
                            new LinkedBlockingQueue<>(10),
                            new DaemonThreadFactory("None--disCardService"),
                            new XyzDiscardPolicy());
                }
            }
        }
        return publicService;
    }

    public ExecutorService getRejectService() {
        if (null == this.rejectService) {
            synchronized (this) {
                if (null == this.rejectService) {
                    rejectService = new ThreadPoolExecutor(1, 2, THREAD_IDLE, TimeUnit.SECONDS,
                            new LinkedBlockingQueue<>(2),
                            new DaemonThreadFactory("None--disCardService"),
                            new RejectExecutionHandlerImpl());
                }
            }
        }
        return rejectService;
    }



}
