package com.yannyao.demo.concurrent.service;


import java.util.Random;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service
// 线程执行任务类
public class AsyncTaskService {

    Random random = new Random();// 默认构造方法

    @Async
    // 表明是异步方法
    // 无返回值
    public void executeAsyncTask(Integer i) {
        System.out.println("执行异步任务：" + i);
    }

    /**
     * 异常调用返回Future
     *
     * @param i
     * @return
     * @throws InterruptedException
     */
    @Async
    public Future<String> asyncInvokeReturnFuture(int i) throws InterruptedException {
        System.out.println("input is " + i);
//        int r = random.nextInt(i);
//        System.out.println("生成的随机数是"+r);
//        Thread.sleep(1000 * r);

        Future<String> future = new AsyncResult<String>("success:" + i);// Future接收返回值，这里是String类型，可以指明其他类型

        return future;
    }
}