package com.leetcode.soulation.c00;

import com.leetcode.soulation.domain.ListNode;

/**
 * @Author:
 * @Date: 2020-10-13 14:50
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
24. 两两交换链表中的节点
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例 1：
输入：head = [1,2,3,4]
输出：[2,1,4,3]

示例 2：
输入：head = []
输出：[]

示例 3：
输入：head = [1]
输出：[1]

提示：

链表中节点的数目在范围 [0, 100] 内
0 <= Node.val <= 100

 */
public class C024 {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        C024 c024 = new C024();
        ListNode listNode = c024.swapPairs(node1);
        while (listNode != null) {
            System.out.print(listNode.val + "\t");
            listNode = listNode.next;
        }
        System.out.println("\n==========");


        // [2,5,3,4,6,2,2]
        ListNode nodeT7 = new ListNode(2, null);
        ListNode nodeT6 = new ListNode(2, nodeT7);
        ListNode nodeT5 = new ListNode(6, nodeT6);
        ListNode nodeT4 = new ListNode(4, nodeT5);
        ListNode nodeT3 = new ListNode(3, nodeT4);
        ListNode nodeT2 = new ListNode(5, nodeT3);
        ListNode nodeT1 = new ListNode(2, nodeT2);
        ListNode listNode1 = c024.swapPairs(nodeT1);
        while (listNode1 != null) {
            System.out.print(listNode1.val + "\t");
            listNode1 = listNode1.next;
        }
        System.out.println("\n==========");
    }

    // 迭代法
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode firstNode = head;
        ListNode lastNode = null;
        ListNode second;
        ListNode newHead = null;
        while (firstNode != null && firstNode.next != null) {
            ListNode thirdNode = firstNode.next.next; // 先将当前节点下一节点，下一节点记录起来：第3个节点
            second = firstNode.next;  // 当前节点下一节点与当前节点对调位置：第2个节点
            firstNode.next = thirdNode; // 第1节点指向第3个节点
            second.next = firstNode;    // 第2节点指向第1节点
            if (newHead == null) newHead = second;
            if (lastNode == null) {
                lastNode = firstNode;
            } else {
                lastNode.next = second;
                lastNode = firstNode;
            }

            firstNode = thirdNode;
        }

        return newHead;
    }
}
