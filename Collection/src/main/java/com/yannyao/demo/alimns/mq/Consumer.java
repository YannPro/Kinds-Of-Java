package com.yannyao.demo.alimns.mq;

/**
 * create by jsm on 2018/7/2
 */
public interface Consumer<T> {

    void consumer();

    boolean handler(T msg);
}
