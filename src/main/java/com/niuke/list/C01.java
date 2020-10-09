package com.niuke.list;

import com.leetcode.soulation.domain.ListNode;

/**
 * @Author:
 * @Date: Created in 3:22 下午 2020/10/9
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 输入一个链表，反转链表后，输出新链表的表头。
public class C01 {
    public static void main(String[] args) {
        // {1,2,3,4,5}
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        C01 c01 = new C01();
        ListNode head = c01.ReverseList(node1);
        while (head != null) {
            System.out.print(head.val +"\t");
            head = head.next;
        }
        System.out.println();
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prevNode = null;
        ListNode nextNode = head.next;
        while (nextNode != null) {
            ListNode newHead = head.next;
            nextNode = newHead.next;
            head.next = prevNode;
            prevNode = head;
            head = newHead;
        }

        head.next = prevNode;

        return head;
    }
}
