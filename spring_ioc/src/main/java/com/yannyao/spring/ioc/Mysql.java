package com.yannyao.spring.ioc;

import com.yannyao.spring.ioc.annotation.Component;

/**
 * @Auther: YJY
 * @Date: 2018/11/6 14:34
 * @Description:
 */
@Component("mysql")
public class Mysql implements Database{
    public void print(){

        System.out.println("component mysql print");
    }
}
