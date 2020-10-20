package com.leetcode.soulation.c100;

import com.leetcode.soulation.domain.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author:
 * @Date: 2020-10-20 17:23
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
143. 重排链表
给定一个单链表L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例1:
给定链表 1->2->3->4, 重新排列为 1->4->2->3.

示例 2:
给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class C143 {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);
        C143 c143 = new C143();
        c143.reorderList(head);

        ListNode currNode = head;
        while (currNode != null) {
            System.out.print(currNode.val + "\t");
            currNode = currNode.next;
        }

        System.out.println("\n==========================");
    }


    // 使用双链表辅助法
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        LinkedList<ListNode> listNodes = new LinkedList<>();
        ListNode currNode = head;
        while (currNode != null) {
            listNodes.add(currNode);
            currNode = currNode.next;
        }

        int start = 0;
        int end = listNodes.size() -1;
        while (start < end) {
            listNodes.get(start).next = listNodes.get(end);
            start++;

            if (start == end) break;

            listNodes.get(end).next = listNodes.get(start);
            end--;
        }

        listNodes.get(start).next = null;
    }

    public void reorderList1(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
