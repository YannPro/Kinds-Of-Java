package com.yannyao.spring.ioc.test;

/**
 * @Auther: YJY
 * @Date: 2018/11/7 14:02
 * @Description:
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        A b = (A) Class.forName("com.yannyao.spring.ioc.test.A").newInstance();
//        System.out.println(b);

        Class clazz = Class.forName("com.yannyao.spring.ioc.test.C");
//        A a= (A)RegSingleton.getInstance("com.yannyao.spring.ioc.test.C");
//        System.out.println(a);
    }
}
