package com.yannyao.demo.algorithm.leetcode.primary.string;

public class ReverseString {
    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(reverseString("hello"));
    }
}
