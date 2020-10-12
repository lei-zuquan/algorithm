package com.leetcode.soulation.c400;

import java.util.Arrays;

/**
 * @Author:
 * @Date: Created in 12:43 下午 2020/10/12
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
416. 分割等和子集
给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

注意:

每个数组中的元素不会超过 100
数组的大小不会超过 200

示例 1:
输入: [1, 5, 11, 5]
输出: true
解释: 数组可以分割成 [1, 5, 5] 和 [11].


示例2:
输入: [1, 2, 3, 5]

输出: false

解释: 数组不能分割成两个元素和相等的子集.
 */

public class C416 {
    public static void main(String[] args) {
        C416 c416 = new C416();
        System.out.println(c416.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(c416.canPartition(new int[]{1, 2, 3, 5}));
    }

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }
        for (int i = 1; i < len; i++) {
            for (int j = target; nums[i] <= j; j--) {
                if (dp[target]) {
                    return true;
                }
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }

}
