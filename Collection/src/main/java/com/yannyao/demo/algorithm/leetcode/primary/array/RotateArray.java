package com.yannyao.demo.algorithm.leetcode.primary.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;

// TODO: 2018/9/10  not ac

/**
 * 优解答案：https://blog.csdn.net/whdAlive/article/details/80356401
 */
public class RotateArray {
    /**
     * 我的答案 超時！！！
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        if(nums.length==0||nums.length==1){
            return;
        }
        k = k % nums.length;
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
        int[] a= new int[]{1,2,3,4,5,6,7};
        rotate(a,2);
    }
}
