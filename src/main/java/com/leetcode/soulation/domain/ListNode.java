package com.leetcode.soulation.domain;

/**
 * @Author:
 * @Date: Created in 2:19 下午 2020/9/30
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode listNode) {
        this.val = val;
        this.next = listNode;
    }
}
