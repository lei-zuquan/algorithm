package com.leetcode.soulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author:
 * @Date: Created in 2:07 下午 2020/9/30
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//示例：
//
//输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
class ListNode {
    int val;
    ListNode next;

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
public class C021 {
    public static void main(String[] args) {
        /*int[] arr1 = {1,2,4};
        int[] arr2 = {1,3,4};

        C021 c021 = new C021();
        int[] arr = c021.mergeArr(arr1, arr2);
        System.out.println(Arrays.toString(arr));*/

        ListNode l4 = new ListNode(4, null);
        ListNode l2 = new ListNode(2, l4);
        ListNode listNode1 = new ListNode(1, l2);

        ListNode ll4 = new ListNode(4, null);
        ListNode ll3 = new ListNode(3, ll4);
        ListNode listNode2 = new ListNode(1, ll3);

        C021 c021 = new C021();
        ListNode listNode = c021.mergeTwoLists(listNode1, listNode2);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode currNode1 = l1;
        ListNode currNode2 = l2;
        List<Integer> list = new LinkedList<>();

        while (currNode1 != null && currNode2 != null) {
            if (currNode1.val <= currNode2.val) {
                list.add(currNode1.val);
                currNode1 = currNode1.next;
            } else {
                list.add(currNode2.val);
                currNode2 = currNode2.next;
            }
        }

        while (currNode1 != null) {
            list.add(currNode1.val);
            currNode1 = currNode1.next;
        }

        while (currNode2 != null) {
            list.add(currNode2.val);
            currNode2 = currNode2.next;
        }


        ListNode lastNode = null;
        for (int i = list.size() - 1; i >= 0 ; i--) {
            lastNode = new ListNode(list.get(i), lastNode);
        }

        return lastNode;
    }



    public int[] mergeArr(int[] arr1, int[] arr2) {
        int[] resArr = new int[arr1.length + arr2.length];
        int start1 = 0;
        int start2 = 0;
        int end1 = arr1.length -1;
        int end2 = arr2.length -1;
        int index = 0;

        while (start1 <= end1 && start2 <= end2) {
            if (arr1[start1] <= arr2[start2]) {
                resArr[index++] = arr1[start1++];
            } else {
                resArr[index++] = arr2[start2++];
            }
        }

        while (start1 <= end1) {
            resArr[index++] = arr1[start1++];
        }
        while (start2 <= end2) {
            resArr[index++] = arr2[start2++];
        }

        return resArr;
    }


}
