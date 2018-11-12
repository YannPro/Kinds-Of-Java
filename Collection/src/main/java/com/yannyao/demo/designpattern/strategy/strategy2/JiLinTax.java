package com.yannyao.demo.designpattern.strategy.strategy2;

/**
 * @Auther: YJY
 * @Date: 2018/11/8 15:05
 * @Description:
 */
public class JiLinTax implements Tax {
    //计算吉林子公司的所得税
    public void computerTax() {
        System.out.println("采用吉林算法计算所得税");
    }
}