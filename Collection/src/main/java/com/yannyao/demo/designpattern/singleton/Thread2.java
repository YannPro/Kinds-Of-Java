package com.yannyao.demo.designpattern.singleton;

/**
 * @Auther: YJY
 * @Date: 2018/9/27 15:55
 * @Description:
 */
public class Thread2 implements Runnable{
    @Override
    public void run() {
        Singleton s = Singleton.getInstance();
        System.out.println("thread2"+s);
    }
}
