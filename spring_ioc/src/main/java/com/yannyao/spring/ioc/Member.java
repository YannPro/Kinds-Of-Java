package com.yannyao.spring.ioc;

import com.yannyao.spring.ioc.annotation.Component;

/**
 * @Auther: YJY
 * @Date: 2018/11/6 14:33
 * @Description:
 */
@Component
public class Member {
    public void print(){
        System.out.println("component member print member");
    }
}
