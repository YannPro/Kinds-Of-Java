package com.yannyao.spring.aop;

import com.yannyao.spring.aop.annotation.After;
import com.yannyao.spring.aop.annotation.Before;
import com.yannyao.spring.aop.annotation.MyAspect;

/**
 * @Auther: YJY
 * @Date: 2018/11/7 17:49
 * @Description:
 */
@MyAspect // 表明这是一个切点类
public class Player {
    @Before("com.yannyao.spring.aop.Music.sing()")  // 前置通知，当调用sing方法被调用的时候该方法会被在它之前调用
    public void beforeSing() {
        System.out.println("开始唱歌前的准备");
    }

    @After("com.yannyao.spring.aop.Music.sing()") // 同理，在调用sing方法之后再来调用该方法
    public void afterSing() {
        System.out.println("唱完之后开始评分");
    }
}