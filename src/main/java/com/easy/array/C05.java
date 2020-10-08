package com.easy.array;

import java.util.Arrays;

/**
 * @Author:
 * @Date: 2020-10-08 9:17
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
只出现一次的数字
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：
    你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:
    输入: [2,2,1]
    输出: 1

示例2:
    输入: [4,1,2,1,2]
    输出: 4
 */
public class C05 {
    public static void main(String[] args) {
        C05 c05 = new C05();
        System.out.println(c05.singleNumber(new int[]{2, 2, 1}));
        System.out.println(c05.singleNumber(new int[]{4,1,2,1,2}));
        System.out.println(c05.singleNumber(new int[]{5,5,4,1,1,3,3}));
    }

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = nums[i] ^ res;
        }
        return res;
    }

    public int singleNumber2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i+=2) {
            if (nums[i-1] != nums[i]) {
                return nums[i-1];
            }
        }

        return nums[nums.length-1];
    }
}
