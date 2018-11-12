package com.yannyao.demo.designpattern.strategy.strategy2;

/**
 * @Auther: YJY
 * @Date: 2018/11/8 15:04
 * @Description:
 */
public class HeBeiTax implements Tax{
    //计算河北子公司的所得税
    public void computerTax() {
        System.out.println("采用河北算法计算所得税");
    }
}