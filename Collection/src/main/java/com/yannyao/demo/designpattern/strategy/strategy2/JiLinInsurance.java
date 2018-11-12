package com.yannyao.demo.designpattern.strategy.strategy2;

/**
 * @Auther: YJY
 * @Date: 2018/11/8 15:05
 * @Description:
 */
public class JiLinInsurance implements Insurance {
    //计算吉林子公司的保险
    public void computerInsurance() {
        System.out.println("采用吉林算法计算保险");
    }
}