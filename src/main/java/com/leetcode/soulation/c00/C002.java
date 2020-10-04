package com.leetcode.soulation.c00;

import com.leetcode.soulation.domain.ListNode;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.List;

/**
 * @Author:
 * @Date: 2020-10-04 9:48
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*

2. 两数相加
给出两个非空 的链表用来表示两个非负的整数。
其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 */
public class C002 {
    public static void main(String[] args) {
        C002 c002 = new C002();
        ListNode l1Node3 = new ListNode(3);
        ListNode l1Node4 = new ListNode(4, l1Node3);
        ListNode l1Node2 = new ListNode(2, l1Node4);

        ListNode l2Node4 = new ListNode(4);
        ListNode l2Node6 = new ListNode(6, l2Node4);
        ListNode l2Node5 = new ListNode(5, l2Node6);

        ListNode listNode = c002.addTwoNumbers(l1Node2, l2Node5);
        ListNode currNode = listNode;
        while (currNode != null) {
            System.out.println(currNode.val);
            currNode = currNode.next;
        }

        System.out.println("========================");
        ListNode l1Node11 = new ListNode(9);
        ListNode l1Node12 = new ListNode(9, l1Node11);
        ListNode l1Node13 = new ListNode(9, l1Node12);
        ListNode l1Node14 = new ListNode(9, l1Node13);
        ListNode l1Node15 = new ListNode(9, l1Node14);
        ListNode l1Node16 = new ListNode(9, l1Node15);
        ListNode l1Node17 = new ListNode(9, l1Node16);

        ListNode l1Node21 = new ListNode(9);
        ListNode l1Node22 = new ListNode(9, l1Node21);
        ListNode l1Node23 = new ListNode(9, l1Node22);
        ListNode l1Node24 = new ListNode(9, l1Node23);

        ListNode listNode22 = c002.addTwoNumbers(l1Node17, l1Node24);
        ListNode currNode22 = listNode22;
        while (currNode22 != null) {
            System.out.println(currNode22.val);
            currNode22 = currNode22.next;
        }
    }

    // 迭代法
    // 因为从链表往下个节点变换时，依次是个位、十位、百位
    // 从链表头向下依次遍历叠加
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = null;
        ListNode prevNode = null;

        int lastVal = 0;
        ListNode l1CurrNode = l1;
        ListNode l2CurrNode = l2;
        while (l1CurrNode != null || l2CurrNode != null) {
            int val1 = 0;

            if (l1CurrNode != null) {
                val1 = l1CurrNode.val;
                l1CurrNode = l1CurrNode.next;
            }


            int val2 = 0;
            if (l2CurrNode != null) {
                val2 = l2CurrNode.val;
                l2CurrNode = l2CurrNode.next;
            }

            int newVal = val1 + val2 + lastVal;
            ListNode newNode = new ListNode(newVal % 10);
            lastVal = newVal / 10;
            if (newHead == null) {
                newHead = newNode;
            } else {
                prevNode.next = newNode;
            }
            prevNode = newNode;
        }

        // 最后判断一下，进位是否存在
        if (lastVal > 0) {
            ListNode newNode = new ListNode(lastVal);
            prevNode.next = newNode;
        }

        return newHead;
    }
}
