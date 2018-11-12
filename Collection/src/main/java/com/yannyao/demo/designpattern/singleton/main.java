package com.yannyao.demo.designpattern.singleton;

/**
 * @Auther: YJY
 * @Date: 2018/9/27 15:54
 * @Description:
 */
public class main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread2());
        thread1.start();
        thread2.start();
    }
}
