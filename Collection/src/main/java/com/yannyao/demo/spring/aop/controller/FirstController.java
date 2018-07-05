package com.yannyao.demo.spring.aop.controller;

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
}