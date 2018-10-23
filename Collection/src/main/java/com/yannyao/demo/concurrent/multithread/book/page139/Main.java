package com.yannyao.demo.concurrent.multithread.book.page139;

/**
 * @Auther: YJY
 * @Date: 2018/9/26 23:32
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        try {

            Object lock = new Object();
            Thread1 thread1 = new Thread1(lock);
            Thread2 thread2 = new Thread2(lock);

            thread2.start();
            Thread.sleep(1000);
            thread1.start();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
