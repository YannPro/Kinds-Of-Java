package com.yannyao.demo.concurrent.multithread.book.page139;

/**
 * @Auther: YJY
 * @Date: 2018/9/26 23:26
 * @Description:
 */
public class Thread2 extends Thread{
    private Object lock;

    public Thread2(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        super.run();
        try {
            synchronized (lock) {
                lock.wait();
                System.out.println("数组到五个了");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
