package com.yannyao.demo2.d;

/**
 * @Auther: YJY
 * @Date: 2018/11/12 15:57
 * @Description:
 */

public class HelloServiceImpl implements IHelloService {

    @Override
    public String sayHello(String name) {
        return "你好，" + name;
    }
}