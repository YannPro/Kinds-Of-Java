package com.yannyao.demo.concurrent.multithread.Lock.UnReentrantLock;

/**
 * @Auther: YJY
 * @Date: 2018/12/3 00:07
 * @Description:
 */
public class Count{
    Lock lock = new Lock();
    public volatile int n = 0;
    public void print(){
        try {
            lock.lock();
            doAdd();
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void doAdd(){
        try {
            lock.lock();
            n++;
            System.out.println(n);
            //do something
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}