package com.yannyao.spring.ioc;

import com.yannyao.spring.ioc.annotation.Autowired;
import com.yannyao.spring.ioc.annotation.Component;
import com.yannyao.spring.ioc.annotation.Qualifier;

/**
 * @Auther: YJY
 * @Date: 2018/11/6 14:30
 * @Description:
 */
@Component
public class World {
    @Autowired
    private Hello hello;
    @Autowired
    @Qualifier("mysql")
    private Database db;
    @Autowired
    private Member member;

    public void print(){
        hello.print();
        member.print();
        db.print();
        System.out.println("component world print world");
    }
}
