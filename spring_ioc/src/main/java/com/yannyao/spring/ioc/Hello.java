package com.yannyao.spring.ioc;

import com.yannyao.spring.ioc.annotation.Autowired;
import com.yannyao.spring.ioc.annotation.Component;

/**
 * @Auther: YJY
 * @Date: 2018/11/6 14:31
 * @Description:
 */
@Component
public class Hello {
    @Autowired
    User user;
    public void print(){
        user.print();
        System.out.println("componet hello");
    }
}
