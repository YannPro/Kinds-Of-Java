package com.yannyao.demo.yimo.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ManPojo {
    private String name;
    private int age;
    private String address;
}
