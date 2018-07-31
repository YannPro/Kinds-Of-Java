package com.yannyao.demo.yimo.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class ManVo {

    private String name;

    private int age;

    private String address;

    private double money;

    private List<String> friends;
}
