package com.yannyao.demo.designpattern.strategy.strategy2;

/**
 * @Auther: YJY
 * @Date: 2018/11/8 15:03
 * @Description:
 */
public class HeBeiSalary implements Salary{
    //计算河北子公司的基本工资
    public void computerSalary() {
        System.out.println("采用河北算法计算基本工资");
    }
}