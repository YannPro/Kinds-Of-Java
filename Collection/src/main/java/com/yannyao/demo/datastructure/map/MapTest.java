package com.yannyao.demo.datastructure.map;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: YannYao
 * @Description:
 * @Date Created in 20:56 2018/7/6
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String, String> m = new HashMap<>();
        m.put(new String("1"), "a");
        m.put(new String("2"), "b");
        m.put(new String("1"), "c");
        m.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });
    }

}
