package com.yannyao.spring.cglib;

/**
 * @Auther: YJY
 * @Date: 2018/11/8 13:55
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        CglibTs ct = new CglibTs();
        ClassHasNoInterface chni = (ClassHasNoInterface) ct.getProxy(ClassHasNoInterface.class);
        chni.method();
        chni.function();
    }
}
