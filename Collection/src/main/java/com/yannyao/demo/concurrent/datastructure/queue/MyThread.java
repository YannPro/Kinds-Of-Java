package com.yannyao.demo.concurrent.datastructure.queue;

class MyThread extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(500);
            Thread t = Thread.currentThread();
            System.out.println(this+"当前线程名字：" + t.getName() + " 当前线程的优先级别为："+ t.getPriority() + " ID:" + t.getId());
//			System.out.println("当前线程名字：" + this.getName() + " 当前线程的优先级别为：" + this.getPriority() + " ID:"+ this.getId());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}