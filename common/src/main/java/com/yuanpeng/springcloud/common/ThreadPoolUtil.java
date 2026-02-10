package com.yuanpeng.springcloud.common;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class ThreadPoolUtil {

    public static ThreadPoolExecutor threadPool(){
    return new ThreadPoolExecutor(10
            , 20
            , 1L
            , TimeUnit.SECONDS
            , new LinkedBlockingQueue<>(100)
            , Executors.defaultThreadFactory()
            , new ThreadPoolExecutor.AbortPolicy());

    }

    public static ThreadPoolTaskExecutor threadPoolTask(){
        ThreadPoolTaskExecutor threadPoolTask = new ThreadPoolTaskExecutor();
        threadPoolTask.setCorePoolSize(10);
        threadPoolTask.setMaxPoolSize(20);
        threadPoolTask.setKeepAliveSeconds(1);
        threadPoolTask.setQueueCapacity(100);
        threadPoolTask.setThreadFactory(Executors.defaultThreadFactory());
        threadPoolTask.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        threadPoolTask.initialize();

        return threadPoolTask;

    }




}
