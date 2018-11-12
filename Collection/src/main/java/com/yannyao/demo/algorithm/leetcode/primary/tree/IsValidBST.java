package com.yannyao.demo.algorithm.leetcode.primary.tree;

/**
 * @Auther: YJY
 * @Date: 2018/11/12 10:10
 * @Description:二叉搜索树
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/48/
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class IsValidBST {

    public static boolean isValidBST(TreeNode root) {
        return true;
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        /*
        *       10
        *      / \
        *     5  15
        *       / \
        *      6   20
        *
        *
        */
        TreeNode treeNode = new TreeNode(10);
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(15);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(20);
        treeNode.left = t1;
        treeNode.right = t2;
        t2.left = t3;
        t2.right = t4;
        System.out.println(isValidBST(treeNode));
    }
}
