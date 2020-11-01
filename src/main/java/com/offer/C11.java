package com.offer;

import java.util.Arrays;

/**
 * @Author:
 * @Date: 2020-11-01 8:10
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
剑指 Offer 59 - I. 滑动窗口的最大值
给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

示例:
输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7]
解释:

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

提示：
你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤输入数组的大小。
注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/

 */
public class C11 {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        C11 c11 = new C11();
        int[] ints = c11.maxSlidingWindow(arr, 3);
        System.out.println(Arrays.toString(ints));
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return nums;

        int[] res = new int[nums.length - 2];
        int finishIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i+k > nums.length) break;
            int prev = nums[i];
            int mid = nums[i+1];
            int last = nums[i+2];

            int max = Math.max(Math.max(prev, mid), last);
            res[finishIndex++] = max;
        }

        return res;
    }
}
