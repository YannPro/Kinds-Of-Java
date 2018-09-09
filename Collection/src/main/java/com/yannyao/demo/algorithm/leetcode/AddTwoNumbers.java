package com.yannyao.demo.algorithm.leetcode;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 两数相加
 * 答案:https://leetcode-cn.com/problems/add-two-numbers/solution/
 */
// TODO: 2018/9/8
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;

    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
        }
    }
    public static String reverseString(String str){
        String s="";
        for (int i = str.length()-1; i >= 0; i--) { // 字符串下标从0开始，长度-1结束。倒序所以从长度-1开始，0结束。
            s += str.charAt(i);
        }
        return s;
    }
    public static void printListNode(ListNode l){
        System.out.print(l.val+" ");
        while (l.next != null) {
            System.out.print(l.next.val+" ");
            l.next = l.next.next;
        }
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
//        ListNode l2 = new ListNode(4);
//        ListNode l3 = new ListNode(3);
//        l1.next = l2;
//        l2.next = l3;
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(9);
        ListNode l8 = new ListNode(9);
        ListNode l9 = new ListNode(9);
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        //708
        printListNode(addTwoNumbers(l1, l4));
    }


}
