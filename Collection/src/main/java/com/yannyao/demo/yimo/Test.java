package com.yannyao.demo.yimo;

import com.yannyao.demo.yimo.domain.ManPojo;
import com.yannyao.demo.yimo.domain.ManVo;

public class Test {
    public static void main(String[] args) {
        ManPojo manPojo = new ManPojo().setAddress("hangzhou")
                                        .setAge(11)
                                        .setName("xiaoming");

        ManVo manVo = new ManVo().setMoney(1111.22);

        ManVo o = TransferUtil.copyBean(manPojo, ManVo.class);

        System.out.println(o);
    }
}
