package com.yannyao.demo.Test;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.io.IOException;

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

    public static void main(String args[])
    {
        Test st1 = new Test();
        st1.print();
//        Test st2 = new Test();
//        st2.print();
    }
}