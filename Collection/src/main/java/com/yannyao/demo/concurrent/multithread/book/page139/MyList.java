package com.yannyao.demo.concurrent.multithread.book.page139;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: YJY
 * @Date: 2018/9/26 23:24
 * @Description:
 */
public class MyList {
    private static List list = new ArrayList();
    public static void add(){
        list.add("any string");
    }
    public static int size(){
        return list.size();
    }
}
