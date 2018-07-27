package com.yannyao.demo.spring.aop.controller;

import com.yannyao.demo.spring.aop.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @RequestMapping("/first")
    public Object first() {
        return "first controller";
    }

    @RequestMapping("/doError")
    private Object error() {
        return 1 / 0;
    }

    @GetMapping("/user")
    private String user(User user) {
        System.out.println(user);
        return "ssss";
    }
}