package com.yannyao.demo.Test;

public enum ShopCartProStatus {

    SALEOUT("SALEOUT", "商品已售罄"),
    OFFSALE("OFFSALE", "商品已下架"),
    INVALID("INVALID", "商品已失效"),
    ;
    String value;
    String desc;

    ShopCartProStatus(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String value() {
        return this.value;
    }

    public String desc() {
        return this.desc;
    }
}
