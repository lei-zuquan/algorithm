package com.leetcode.soulation.c00;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author:
 * @Date: 2020-10-11 20:46
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
1. 两数之和

给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

示例:
给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

 */
public class C001 {
    public static void main(String[] args) {
        C001 c09 = new C001();
        int[] ints = c09.twoSum(new int[]{2, 7, 11, 15}, 22);
        System.out.println(Arrays.toString(ints));
    }

    // 方法一：暴力枚举
    // 时间复杂度：O(n^2)
    // 空间复杂度：O(1)
    public int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }

        return res;
    }

    // 哈希表法
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                Integer prevIndex = hashMap.get(target - nums[i]);
                res[0] = prevIndex;
                res[1] = i;
                return res;
            }
            hashMap.put(nums[i], i);
        }

        return res;
    }
}
