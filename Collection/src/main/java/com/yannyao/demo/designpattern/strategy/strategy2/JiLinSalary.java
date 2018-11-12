package com.yannyao.demo.designpattern.strategy.strategy2;

/**
 * @Auther: YJY
 * @Date: 2018/11/8 15:04
 * @Description:
 */
public class JiLinSalary implements Salary {
    //计算吉林子公司的基本工资
    public void computerSalary() {
        System.out.println("采用吉林算法计算基本工资");
    }
}