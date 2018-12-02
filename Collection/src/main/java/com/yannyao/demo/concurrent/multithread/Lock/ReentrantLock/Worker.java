package com.yannyao.demo.concurrent.multithread.Lock.ReentrantLock;

/**
 * @Auther: YJY
 * @Date: 2018/12/3 00:09
 * @Description:
 */
public class Worker implements Runnable{
    @Override
    public void run() {
        Count count = new Count();
        count.print();
    }
}
