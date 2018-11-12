package com.yannyao.demo.designpattern.singleton;

/**
 * @Auther: YJY
 * @Date: 2018/9/27 15:53
 * @Description:
 */
class Singleton{
    private static Singleton singleton = null;

    private Singleton(){

    }
    public static synchronized Singleton getInstance(){
        if(null == singleton){
            singleton = new Singleton();
        }
        return singleton;
    }

}
