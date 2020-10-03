package com.leetcode.soulation.c200;

import com.leetcode.soulation.domain.ListNode;

/**
 * @Author:
 * @Date: 2020-10-03 11:24
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
237. 删除链表中的节点
请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。

 */
public class C237 {

    public static void main(String[] args) {

    }

    // 将下一个节点的值赋值到当前节点的val，然后当前节点指针指向【当前节点的下一个、下一个节点】即可
    // 时间复杂度：O(1)
    // 空间复杂度：O(1)
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
