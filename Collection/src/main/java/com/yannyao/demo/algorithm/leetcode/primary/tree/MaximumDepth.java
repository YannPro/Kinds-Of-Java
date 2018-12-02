package com.yannyao.demo.algorithm.leetcode.primary.tree;

/**
 * 二叉树的最大深度
 *https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/47/
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 */
public class MaximumDepth {

    public static  int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int a = maxDepth(root.left)+1;
        int b = maxDepth(root.right)+1;
        int deep=a>b?a:b;
        return deep;
    }

    public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(6);
        treeNode.left = t1;
        treeNode.right = t2;
        t1.left = t3;
        t3.right = t4;
        t3.left = t5;
        System.out.println(maxDepth(treeNode));
    }
}
