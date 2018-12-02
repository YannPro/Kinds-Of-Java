package com.yannyao.demo.concurrent.multithread.Lock.UnReentrantLock;

/**
 * @Auther: YJY
 * @Date: 2018/12/3 00:08
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            Worker worker = new Worker();
            Thread thread = new Thread(worker);
            thread.start();
        }
    }
}
