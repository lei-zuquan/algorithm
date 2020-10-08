package com.easy.c05_sort_find;

import java.util.Arrays;

/**
 * @Author:
 * @Date: 2020-10-08 11:25
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
88. 合并两个有序数组

给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。

说明:

初始化nums1 和 nums2 的元素数量分别为m 和 n 。
你可以假设nums1有足够的空间（空间大小大于或等于m + n）来保存 nums2 中的元素。

示例:
输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出:[1,2,2,3,5,6]

 */
public class C01 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3,0,0,0};
        int[] arr2 = new int[]{2,5,6};

        C01 c01 = new C01();
        c01.merge(arr1, 3, arr2, 3);

        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + "\t");
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m;
        for (int i = 0; i < nums2.length; i++) {
            nums1[index++] = nums2[i];
        }

        Arrays.sort(nums1);
    }

    // 双指针，从后往前遍历
}
