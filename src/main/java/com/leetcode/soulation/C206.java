package com.leetcode.soulation;

import com.leetcode.soulation.domain.ListNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author:
 * @Date: 2020-10-02 20:31
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
206. 反转链表

反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

 */
public class C206 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode currNode = node1;
        while (currNode != null) {
            System.out.print(currNode.val + "\t\t");
            currNode = currNode.next;
        }

        System.out.println();
        System.out.println("==========================");
        C206 c206 = new C206();
        ListNode listNode = c206.reverseList(node1);
        while (listNode != null) {
            System.out.print(listNode.val + "\t\t");
            listNode = listNode.next;
        }
    }

    // 迭代法：使用前驱、后驱节点进行遍历，将单向链表指针反向
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public ListNode reverseList(ListNode head) {
        // 先做安全检查，判断头节点是否为空
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        // 通过上述操作，排除了单向链表空、只有一个节点的情况

        ListNode newHead = head;
        ListNode currNode = head.next;

        // 因为开头排除了：单向链表空、只有一个节点的情况；所以这里只处理单向链表元素在2个及2个以上
        while (currNode != null) {
            ListNode oldNextNode = currNode.next;
            currNode.next = newHead;
            newHead = currNode;
            currNode = oldNextNode;
        }

        head.next = null;
        return newHead;
    }

    // 使用栈作为辅助结构，根据栈先进后出的特性满足单向链表反向
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public ListNode reverseList2(ListNode head) {
        // 先做安全检查，判断头节点是否为空
        if (head == null) {
            return null;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode currNode = head;
        while (currNode != null) {
            stack.push(currNode);
            currNode = currNode.next;
        }

        ListNode newHead = null;
        ListNode prevNode = null;
        while (stack.size() > 0) {
            ListNode node = stack.pop();
            if (newHead == null) {
                newHead = node;
            } else {
                prevNode.next = node;
            }
            prevNode = node;
        }
        prevNode.next = null;

        return newHead;
    }

    // 使用双向链表作为额外空间辅助，遍历单向链表时不断向双向链表添加；然后通过双向链表从尾部遍历获取反向单向链表
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public ListNode reverseList1(ListNode head) {
        // 先做安全检查，判断头节点是否为空
        if (head == null) {
            return null;
        }

        LinkedList<ListNode> list = new LinkedList<>();
        ListNode currNode = head;
        while (currNode != null) {
            list.add(currNode);
            currNode = currNode.next;
        }

        ListNode newHead = null;
        ListNode prevNode = null;
        for (int i = list.size() - 1; i >= 0; i--) {
            ListNode listNode = list.get(i);
            listNode.next = null;
            if (newHead == null){
                newHead = listNode;
                prevNode = newHead;
            } else {
                prevNode.next = listNode;
                prevNode = listNode;
            }
        }

        return newHead;
    }
}
