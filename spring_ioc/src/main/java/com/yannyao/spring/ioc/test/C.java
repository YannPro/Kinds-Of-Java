package com.yannyao.spring.ioc.test;

/**
 * @Auther: YJY
 * @Date: 2018/11/7 15:10
 * @Description:
 */
public class C<F extends D> implements A{
    public String c = "c";

    @Override
    public void c() {
        System.out.println("cccc");
    }
}
