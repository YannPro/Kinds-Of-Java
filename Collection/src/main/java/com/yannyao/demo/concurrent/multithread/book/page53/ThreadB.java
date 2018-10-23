package com.yannyao.demo.concurrent.multithread.book.page53;

/**
 * @Auther: YJY
 * @Date: 2018/9/20 23:25
 * @Description:
 */
public class ThreadB extends Thread{
    private HasSelfPrivateNum numRef;

    public ThreadB(HasSelfPrivateNum numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("b");
    }
}
