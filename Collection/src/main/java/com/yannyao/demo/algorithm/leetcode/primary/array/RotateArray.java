package com.yannyao.demo.algorithm.leetcode.primary.array;

import java.util.Arrays;

// TODO: 2018/9/10  not ac
public class RotateArray {
    public static void rotate(int[] nums, int k) {

        if(nums.length==0||nums.length==1){
            return;
        }
        for (int j = 0; j < k; j++) {
            int[] t = nums.clone();
            int first = nums[0],
                    last = nums[nums.length-1];
            nums[0]=last;
            for (int i = 0; i < nums.length; i++) {
                if (i==nums.length-1){
                    continue;
                } else {
                    nums[i+1] = t[i];

                }
            }
        }
        System.out.println(Arrays.toString(nums));

    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53};
        rotate(a, 82);
    }
}
