package com.yannyao.demo.algorithm.leetcode.primary.tree;

public class MaximumDepth {

    public int maxDepth(TreeNode root) {
        int count = 0;
        if(root==null){
            return 0;
        }

        while (root.right!=null || root.left!=null){
            if(root.left!=null) {

            }
        }
        return 0;
    }

    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
    public static void main(String[] args) {

    }
}
