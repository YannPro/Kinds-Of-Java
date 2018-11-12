package com.yannyao.spring.ioc;

import com.yannyao.spring.ioc.annotation.Component;

/**
 * @Auther: YJY
 * @Date: 2018/11/6 14:30
 * @Description:
 */
@Component
public class User {
    public void print(){
        System.out.println("component user print yjy");
    }
}
