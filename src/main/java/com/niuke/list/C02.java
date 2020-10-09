package com.niuke.list;

import com.leetcode.soulation.domain.ListNode;

import java.util.List;

/**
 * @Author:
 * @Date: Created in 3:31 下午 2020/10/9
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
判断给定的链表中是否有环
扩展：
你能给出空间复杂度的解法么？
 */
public class C02 {

    public static void main(String[] args) {

    }
    // 快慢双指针
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slowNode = head;
        ListNode quickNode = head;

        while (quickNode != null) {
            slowNode = slowNode.next;
            if (quickNode.next != null) {
                quickNode = quickNode.next.next;
            } else {
                return false;
            }


            if (slowNode == quickNode) {
                return true;
            }
        }

        return false;
    }
}
