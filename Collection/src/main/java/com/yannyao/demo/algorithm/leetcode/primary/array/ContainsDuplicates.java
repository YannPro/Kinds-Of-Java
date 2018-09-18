package com.yannyao.demo.algorithm.leetcode.primary.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 题目链接:https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/24/
 * 答案链接:https://blog.csdn.net/wkskys/article/details/79872088
 * */
public class ContainsDuplicates {
    public static boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length==0) return false;
        System.out.println(Arrays.toString(nums));

        Set set = new HashSet();
        for (int num : nums) {
            set.add(num);
        }
        System.out.println(set.size()+","+nums.length);
        if(set.size() == nums.length) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{3,1}));
    }
}
