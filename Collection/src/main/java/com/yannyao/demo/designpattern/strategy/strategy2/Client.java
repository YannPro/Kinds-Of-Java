package com.yannyao.demo.designpattern.strategy.strategy2;

/**
 * @Auther: YJY
 * @Date: 2018/11/8 15:06
 * @Description:
 */
public class Client {
    public static void main(String[] argv) {
        SalaryTemplate salaryTemplate = new SalaryTemplate();
        salaryTemplate.setSalary(new JiLinSalary());
        salaryTemplate.setInsurance(new JiLinInsurance());
        salaryTemplate.setTax(new JiLinTax());
        salaryTemplate.computer();
    }
}