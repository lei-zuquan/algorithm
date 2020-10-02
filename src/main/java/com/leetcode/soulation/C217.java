package com.leetcode.soulation;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author:
 * @Date: 2020-10-02 22:27
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
217. 存在重复元素
给定一个整数数组，判断是否存在重复元素。

如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false

 */
public class C217 {
    public static void main(String[] args) {
        C217 c217 = new C217();
        System.out.println(c217.containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(c217.containsDuplicate(new int[]{1,2,3,4}));
        System.out.println(c217.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }

    // 先排序，再遍历。如果存在相同元素，则前驱元素必定会与当前遍历元素相同
    // 时间复杂度：O(nlogn)
    // 空间复杂度：O(1)
    public boolean containsDuplicate1(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] == nums[i]) {
                return true;
            }
        }

        return false;
    }

    // HashMap法：遍历数组元素，并向hashMap中判断之前是否存在；
    // 如果存在则存在重复元素、不存在的话则向hashMap中插入元数
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                return true;
            }
            hashMap.put(nums[i], i);
        }

        return false;
    }









}
