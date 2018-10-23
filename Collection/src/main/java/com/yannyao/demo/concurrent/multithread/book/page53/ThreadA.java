package com.yannyao.demo.concurrent.multithread.book.page53;

/**
 * @Auther: YJY
 * @Date: 2018/9/20 23:25
 * @Description:
 */
public class ThreadA extends Thread{
    private HasSelfPrivateNum numRef;

    public ThreadA(HasSelfPrivateNum numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("a");
    }
}
