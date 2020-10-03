package com.leetcode.soulation.c00;

// 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
// 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
public class C035 {
    public static void main(String[] args) {
        int[] arr1 = {1,3,5};

        C035 c035 = new C035();
        System.out.println(c035.searchInsert(arr1, 4));
        System.out.println(c035.searchInsert(arr1, 2));
        System.out.println(c035.searchInsert(arr1, 7));
        System.out.println(c035.searchInsert(arr1, 100));
        System.out.println(c035.searchInsert(arr1, 0));
        System.out.println(c035.searchInsert(arr1, -10));

        int[] arr2 = {2,7,8,9,10};
        System.out.println(c035.searchInsert(arr2, 9));
    }

    // 采用二分查找：时间复杂度 O(log(N)
    public int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length -1;
        boolean isBig = false;
        boolean isSmall = false;
        int resValue = -1;
        while (start <= end) {
            //int mid = (start + end) / 2;
            int mid = end + (start - end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                start = mid+1;
                if (isSmall) {
                    resValue = start;
                }
                isBig = true;
            } else {
                end = mid-1;
                if (isBig) {
                    resValue = mid;
                }
                isSmall = true;

            }
        }

        if (resValue != -1) {
            return resValue;
        }

        // 做边界最后检查：前尾
        if (end == -1) {
            return 0;
        } else {
            return nums.length;
        }
    }

    // 时间复杂度为O(n)
    public int searchInsert1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target || nums[i] > target) {
                return i;
            }
        }

        return nums.length;
    }
}
