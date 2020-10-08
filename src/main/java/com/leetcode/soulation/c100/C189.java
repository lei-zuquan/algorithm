package com.leetcode.soulation.c100;

/**
 * @Author:
 * @Date: 2020-10-07 21:47
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
189. 旋转数组

给定一个数组，将数组中的元素向右移动k个位置，其中k是非负数。

示例 1:
输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]

示例2:
输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释:
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
说明:

尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
要求使用空间复杂度为O(1) 的原地算法。

 */
public class C189 {
    public static void main(String[] args) {
        C189 c03 = new C189();
        int[] arr1 = {1,2,3,4,5,6,7};
        c03.rotate(arr1, 3);
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + "\t");
        }
        System.out.println("\n=================");
        int[] arr2 = {-1,-100,3,99};
        c03.rotate(arr2, 2);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + "\t");
        }


        System.out.println("\n=================");
        int[] arr3 = {1};
        c03.rotate(arr3, 2);
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + "\t");
        }
    }

    // 暴力解法
    // 时间复杂度：O(n^2)
    // 空间复杂度：O(1)
    public void rotate1(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            for (int index = nums.length-1; index >0; index--) {
                int temp = nums[index];
                nums[index] = nums[index-1];
                nums[index-1] = temp;
            }
        }
    }

    // 反转法
    // 先整体反转，再反转前k，再反转剩余的；需要考虑k比数组大的情况使用 k %= nums.length
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public void rotate(int[] nums, int k) {
        if (nums.length <= 1) return;

        k %= nums.length;
        // 先整体反转
        reverse(nums, 0, nums.length -1);
        // 再反转前k
        reverse(nums, 0, k-1);
        // 再反转剩余的
        reverse(nums, k, nums.length-1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }


}
