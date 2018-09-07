package com.yannyao.demo.alimns.mq;

/**
 * create by jsm on 2018/7/2
 */
@FunctionalInterface
public interface Producer<T> {
     void producer(String topic, T msg);
}
