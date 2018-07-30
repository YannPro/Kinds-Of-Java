package com.yannyao.demo.Test;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.io.IOException;
import java.util.List;

/**
 * @Author: YannYao
 * @Description:
 * @Date Created in 18:22 2018/6/25
 */
public class Test
{
    static
    {
        String s = String.format("%s %s","s","s");
        System.out.println(s);
//        System.out.println("Hi there");
    }

    public void print()
    {

        System.out.println("Hello");
    }

    public static void test(int... a){
        System.out.println(a[0]);
    }
    public static void main(String args[])
    {
        test(1);
        List<Integer> list = null;
        for (Integer i: list){
            System.out.println(i);
        }
//        Test st1 = new Test();
//        st1.print();
//        Test st2 = new Test();
//        st2.print();
    }
}