package com.easy.array;

import java.util.Arrays;

/**
 * @Author:
 * @Date: 2020-10-08 9:02
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
存在重复元素

给定一个整数数组，判断是否存在重复元素。
如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。

示例 1:
输入: [1,2,3,1]
输出: true

示例 2:
输入: [1,2,3,4]
输出: false

示例3:
输入: [1,1,1,3,3,4,3,2,4,2]
输出: true
 */
public class C04 {
    public static void main(String[] args) {
        C04 c04 = new C04();
        System.out.println(c04.containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(c04.containsDuplicate(new int[]{1,2,3,4}));
        System.out.println(c04.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] == nums[i]) return true;
        }
        return false;
    }
}
