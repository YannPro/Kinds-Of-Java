package com.yannyao.spring.ioc;

import com.yannyao.spring.ioc.config.AnnotationConfigApplicationContext;
import com.yannyao.spring.ioc.config.ApplicationContext;
import com.yannyao.spring.ioc.test.A;
import com.yannyao.spring.ioc.test.C;

import java.util.HashMap;

/**
 * @Auther: YJY
 * @Date: 2018/11/6 14:36
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com");
        Member world = (Member) applicationContext.getBean(Member.class);
        world.print();
        A<?> a = new C();
        a.c();
    }
}
