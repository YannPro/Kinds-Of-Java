package com.yannyao.demo.spring.aop;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {

    private Date endAt;
    String name;

    public User(Date endAt, String name) {
        this.endAt = endAt;
        this.name = name;
    }

    public User() {
    }

    public Date getEndAt() {
        return endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
