package com.leetcode.soulation;

import java.util.Arrays;

/**
 * @Author:
 * @Date: 2020-10-01 21:42
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。

说明:

初始化nums1 和 nums2 的元素数量分别为m 和 n 。
你可以假设nums1 有足够的空间（空间大小大于或等于m + n）来保存 nums2 中的元素。

示例:
输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3
输出:[1,2,2,3,5,6]
 */
public class C088 {
    public static void main(String[] args) {
        C088 c088 = new C088();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        c088.merge(nums1, 3, nums2, 3);

        System.out.println(Arrays.toString(nums1));
    }

    // 时间复杂度 : O(n + m)O(n+m)。
    // 空间复杂度 : O(m)O(m)。
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] newArr = new int[m+n];
        int pos1 = 0;
        int pos2 = 0;
        int finishIndex = 0;
        while (pos1 < m && pos2 < n) {
            if (nums1[pos1] <= nums2[pos2]) {
                newArr[finishIndex++] = nums1[pos1++];
            } else {
                newArr[finishIndex++] = nums2[pos2++];
            }
        }

        while (pos1 < m) {
            newArr[finishIndex++] = nums1[pos1++];
        }

        while (pos2 < n) {
            newArr[finishIndex++] = nums2[pos2++];
        }

        for (int i = 0; i < newArr.length; i++) {
            nums1[i] = newArr[i];
        }
    }
}
