package com.yannyao.demo.concurrent.multithread.book.page139;

/**
 * @Auther: YJY
 * @Date: 2018/9/26 23:26
 * @Description:
 */
public class Thread1 extends Thread{
    private Object lock;

    public Thread1(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        super.run();
        synchronized (lock) {
            for (int i = 0; i < 10; i++) {
                MyList.add();
                if (MyList.size()==5){
                    lock.notify();
                }
            }
        }
    }
}
