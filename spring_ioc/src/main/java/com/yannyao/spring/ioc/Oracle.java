package com.yannyao.spring.ioc;

import com.yannyao.spring.ioc.annotation.Component;

/**
 * @Auther: YJY
 * @Date: 2018/11/6 14:35
 * @Description:
 */
@Component
public class Oracle implements Database{
    public void print(){
        System.out.println("componet oracle print oracle");
    }
}
