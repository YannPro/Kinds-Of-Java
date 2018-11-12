package com.yannyao.demo.designpattern.strategy.strategy2;

/**
 * @Auther: YJY
 * @Date: 2018/11/8 15:05
 * @Description:
 */
public class SalaryTemplate {

    public void computer () {
        salary.computerSalary();
        insurance.computerInsurance();
        tax.computerTax();
    }

    public Insurance getInsurance(){ return insurance; }

    public void setInsurance(Insurance insurance){ this.insurance = insurance; }

    public Tax getTax(){ return tax; }

    public void setTax(Tax tax){ this.tax = tax; }

    public Salary getSalary(){ return salary; }

    public void setSalary(Salary salary){ this.salary = salary; }

    private Insurance insurance;
    private Tax tax;
    private Salary salary;
}