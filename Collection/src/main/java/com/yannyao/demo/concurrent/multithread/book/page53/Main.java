package com.yannyao.demo.concurrent.multithread.book.page53;

/**
 * @Auther: YJY
 * @Date: 2018/9/20 23:27
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        HasSelfPrivateNum numRef = new HasSelfPrivateNum();
        ThreadA threadA = new ThreadA(numRef);
        threadA.start();
        ThreadB threadB = new ThreadB(numRef);
        threadB.start();
    }
}
