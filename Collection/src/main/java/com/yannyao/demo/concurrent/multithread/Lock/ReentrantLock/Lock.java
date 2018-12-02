package com.yannyao.demo.concurrent.multithread.Lock.ReentrantLock;

/**
 * @Auther: YJY
 * @Date: 2018/12/3 00:04
 * @Description:
 */
public class Lock{
    private boolean isLocked = false;
    public synchronized void lock() throws InterruptedException{
        while(isLocked){
            wait();
        }
        isLocked = true;
    }
    public synchronized void unlock(){
        isLocked = false;
        notify();
    }
}