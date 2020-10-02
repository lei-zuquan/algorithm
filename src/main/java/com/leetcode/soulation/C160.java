package com.leetcode.soulation;

import com.leetcode.soulation.domain.ListNode;

import java.util.HashMap;

/**
 * @Author:
 * @Date: 2020-10-02 12:16
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
编写一个程序，找到两个单链表相交的起始节点。

如果两个链表没有交点，返回 null.
在返回结果后，两个链表仍须保持原有的结构。
可假定整个链表结构中没有循环。
程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。

 */
public class C160 {
    public static void main(String[] args) {
        ListNode tail11 = new ListNode(5);
        tail11 = new ListNode(4, tail11);
        ListNode common = new ListNode(8, tail11);
        ListNode tail111 = new ListNode(1, common);
        tail111 = new ListNode(4, tail111);
        System.out.println("====================");

        //ListNode tail22 = new ListNode(5);
        //tail22 = new ListNode(4, tail22);
        //tail22 = new ListNode(8, tail22);
        ListNode tail22 = new ListNode(1, new ListNode(1));
        tail22 = new ListNode(0, tail22);
        tail22 = new ListNode(5, tail22);

        C160 c160 = new C160();
        ListNode intersectionNode = c160.getIntersectionNode(tail111, null);
        if (intersectionNode == null) {
            System.out.println("null");
        } else {
            System.out.println(intersectionNode.val);
        }
    }

    // 使用A、B指针，走完自己的链表后，再走对方的链表
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 需要做安全检查
        if (headA == null || headB == null) {
            return null;
        }

        ListNode posA = headA;
        ListNode posB = headB;

        int runRoadTimes = 0;
        while (runRoadTimes < 4) {
            if (posA == null) {
                posA = headB;
                runRoadTimes++;
            }
            if (posB == null) {
                posB = headA;
                runRoadTimes++;
            }

            if (posA != null && posB != null && posA == posB) {
                return posA;
            }

            if (posA != null) {
                posA = posA.next;
            }
            if (posB != null) {
                posB = posB.next;
            }
        }

        return null;
    }

    // 使用额外空间辅助
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        HashMap<ListNode, ListNode> hashMap = new HashMap<>();
        ListNode currNode = headA;
        while (currNode != null) {
            hashMap.put(currNode, currNode);
            currNode = currNode.next;
        }

        currNode = headB;
        while (currNode != null) {
            if (hashMap.containsKey(currNode)) {
                return currNode;
            }
            currNode = currNode.next;
        }

        return null;
    }
}
