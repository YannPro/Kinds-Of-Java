package com.yannyao.demo.datastructure.queue;

import java.util.*;
import java.util.concurrent.DelayQueue;

public class Test {

    public static void main(String[] args) {
//        List<Long> longList = new ArrayList<>();
//        longList.add(1L);
//        longList.add(4L);
//        longList.add(3L);
//        longList.add(7L);
//        Queue<Long> queue = new LinkedList<>(longList);
//        queue.add(1L);
//        queue.poll();
////        queue.peek();
//        System.out.println(queue);

        MyThread mt = new MyThread();
        new Thread(mt, "Name1").start();
        new Thread(mt, "Name2").start();
        new Thread(mt).start();
        System.out.println(Thread.currentThread().getName()+"  s"); // main主方法
    }

}
