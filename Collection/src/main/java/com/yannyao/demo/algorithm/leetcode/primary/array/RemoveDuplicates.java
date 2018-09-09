package com.yannyao.demo.algorithm.leetcode.primary.array;


public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[num]) {
                nums[num] = nums[i];
            } else {
                num++;
                nums[num] = nums[i];
            }
        }
        return num + 1;

    }
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,2}));
    }
}
