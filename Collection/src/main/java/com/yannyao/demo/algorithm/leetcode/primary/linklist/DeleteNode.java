package com.yannyao.demo.algorithm.leetcode.primary.linklist;


public class DeleteNode {
    public static void deleteNode(ListNode node, int val) {

        ListNode tNode = node;
        ListNode lastNode = node;//存储上一个node
        while (tNode.next != null) {
            lastNode = tNode;
            if (tNode.next.val == val) {
                lastNode.next = tNode.next.next;
                return;
            }
            tNode = tNode.next;
        }
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
        }
    }
    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        deleteNode(n1, 5);
    }
}
