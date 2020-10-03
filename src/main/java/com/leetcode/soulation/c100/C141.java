package com.leetcode.soulation.c100;

/**
 * @Author:
 * @Date: 2020-10-02 9:26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
给定一个链表，判断链表中是否有环。

如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。

如果链表中存在环，则返回 true 。 否则，返回 false 。

 */

import com.leetcode.soulation.domain.ListNode;

import java.util.HashSet;


public class C141 {
    public static void main(String[] args) {
        C141 c141 = new C141();
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(4);
        head.next = node2;
        node2.next = node0;
        node0.next = node4;
        node4.next = node2;
        System.out.println(c141.hasCycle(head));

        System.out.println("=========================");
        ListNode head22 = new ListNode(1);
        ListNode node22 = new ListNode(2);
        head22.next = node22;
        node22.next = head22;
        System.out.println(c141.hasCycle(head22));

        System.out.println("=========================");
        ListNode head33 = new ListNode(1);
        System.out.println(c141.hasCycle(head33));

        System.out.println("=========================");
        ListNode head44 = new ListNode(1);
        ListNode node44 = new ListNode(2);
        head44.next = node44;
        System.out.println(c141.hasCycle(head44));

        System.out.println(c141.hasCycle(null));
    }

    // 使用快、慢两个指针，慢指针每次向前探寻下一个节点；快指针每次向前探寻下两个节点
    // 时间复杂度： O(n)
    // 空间复杂度： O(1)
    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fastNode = head;
        ListNode slowNode = head;
        while (slowNode != null && fastNode != null) {
            if (slowNode.next == null || fastNode.next == null || fastNode.next.next == null) {
                return false;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;

            // 如果快指针找到下一个节点是null，说明没有环
            if (fastNode == null) {
                return false;
            }

            // 如果快、慢指针相遇，说明单向链表有环
            if (fastNode == slowNode) {
                return true;
            }
        }

        return false;
    }


    // 使用额外存储空间来辅助判断
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode currNode = head;
        while (currNode != null && currNode.next != null) {
            if (set.contains(currNode)) {
                return true;
            }

            set.add(currNode);
            currNode = currNode.next;
        }

        return false;
    }
}
