package com.leetcode.soulation.c200;

import java.util.Arrays;

/**
 * @Author:
 * @Date: 2020-10-11 20:08
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
283. 移动零
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:
输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。
 */
public class C283 {
    public static void main(String[] args) {
        C283 c08 = new C283();
        int[] ints = {0, 1, 0, 3, 12, 0, 11};
        c08.moveZeroes(ints);
        System.out.println(Arrays.toString(ints));
    }

    // 迭代法
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        int finishIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[finishIndex] = nums[i];
                finishIndex++;
            }
        }

        for (int i = finishIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
