package com.yannyao.demo.concurrent.multithread.book.page53;

/**
 * @Auther: YJY
 * @Date: 2018/9/20 23:23
 * @Description:
 */
public class HasSelfPrivateNum {
    public void addI(String username){
        try {
            int num = 0;
            if(username.equals("a")){
                num=100;
                System.out.println("a set over");
                Thread.sleep(2000);
            }else {
                num=200;
                System.out.println("b set over");
            }
            System.out.println(username+" num="+num);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
