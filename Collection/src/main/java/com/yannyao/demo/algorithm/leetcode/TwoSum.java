package com.yannyao.demo.algorithm.leetcode;


/**
 * 1.两数之和
 * 官方答案:https://leetcode-cn.com/articles/two-sum/
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    flag = true;
                }
            }
        }
        if (!flag) {
            result[0] = 0;
            result[1] = 0;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] a = {1,2,3};
        System.out.println(TwoSum.twoSum(new int[]{1,2,4}, 6)[0]);
    }
}
