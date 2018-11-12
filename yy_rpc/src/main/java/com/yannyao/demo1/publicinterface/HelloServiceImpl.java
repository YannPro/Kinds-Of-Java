package com.yannyao.demo1.publicinterface;

/**
 * @Auther: YJY
 * @Date: 2018/11/12 11:50
 * @Description:
 */
public class HelloServiceImpl implements HelloService {
    public String hello(String msg) {
        return msg != null ? msg + " -----> I am fine." : "I am fine.";
    }
}