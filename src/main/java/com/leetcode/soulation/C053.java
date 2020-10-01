package com.leetcode.soulation;

/*
 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:
输入: [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释:连续子数组[4,-1,2,1] 的和最大，为6。
进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class C053 {
    public static void main(String[] args) {
        //int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        //int[] arr = {1, 0, 3, 4};
        int[] arr = {-2,-1,1};
        C053 c053 = new C053();
        int sum = c053.maxSubArray1(arr);
        System.out.println(sum);
    }

    // 贪心算法：若当前指针所指元素之前的和小于0，则丢弃当前元素之前序列
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public int maxSubArray1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int curr; // 记录当前值
        int lastSum = 0; // 记录上一次之和
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            curr = nums[i];
            if (lastSum < 0) {
                // 如果之前的和小于0，则丢弃当前元素之前的序列
                if (curr > maxSum) {
                    maxSum = curr;
                }
                lastSum = 0;
            }

            // 叠加之前元素之和
            lastSum = lastSum + curr;
            // -2, 1, -3, 4, -1, 2, 1, -5, 4
            if (lastSum > maxSum) {
                maxSum = lastSum;
            }
        }

        return maxSum;
    }

}
