package com.yannyao.demo.algorithm.funtime;

/**
 * @Auther: YJY
 * @Date: 2018/9/14 14:32
 * @Description:
 */
public class Card {
    private String name;
    private float rate;

    public Card(String name, float rate) {
        this.name = name;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}
