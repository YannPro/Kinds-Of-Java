package com.yannyao.demo.algorithm.leetcode.primary.string;


public class ReverseInt {
    public static int reverse(int x){
        if (x >= 0) {
            StringBuilder str = new StringBuilder(String.valueOf(x));
            str = str.reverse();
            Long s = Long.parseLong(str.toString());
            if (s>Math.pow(2, 31) - 1){
                return 0;
            }
            return Integer.parseInt(str.toString());
        } else {
            String s = String.valueOf(x);
            s = s.replace("-", "");
            StringBuilder str = new StringBuilder(s);
            str = str.reverse();
            Long s2 = Long.parseLong(str.toString());
            if (s2 > Math.pow(2, 31) - 1){
                return 0;
            }
            str.insert(0, "-");
            return Integer.parseInt(str.toString());
        }
    }

    public static void main(String[] args) {
//        System.out.println(Long.parseLong("9646324351"));
        System.out.println(reverse(-123));
    }
}
