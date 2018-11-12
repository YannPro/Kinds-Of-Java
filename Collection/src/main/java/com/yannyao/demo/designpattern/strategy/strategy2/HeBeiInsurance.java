package com.yannyao.demo.designpattern.strategy.strategy2;

/**
 * @Auther: YJY
 * @Date: 2018/11/8 15:04
 * @Description:
 */
public class HeBeiInsurance implements Insurance{
    //计算河北子公司的保险
    public void computerInsurance() {
        System.out.println("采用河北算法计算保险");
    }
}