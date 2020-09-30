package com.leetcode.soulation;

// 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
//
//不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
//
//元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

public class C027 {
    public static void main(String[] args) {
        int[] arr1 = {3,2,2,3};
        int[] arr2 = {0,1,2,2,3,0,4,2};
        C027 c027 = new C027();
        int res1 = c027.removeElement(arr1, 3);
        System.out.println(res1);

        int res2 = c027.removeElement(arr2, 2);
        System.out.println(res2);

        int[] arr3 = {1};
        int res3 = c027.removeElement(arr3, 1);
        System.out.println(res3);
    }

    public int removeElement(int[] nums, int val) {
        // 如果数组长度等于0，代表无需进行数据分析
        if (nums.length == 0) {
            return 0;
        }

        // 表示已经完成的数组索引下标
        int finish = 0;
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) { // 如果找到数组中是我们想要剔除的数据，则将它添加到完成的列表中
                nums[finish++] = nums[i];
            }
        }
        return finish;
    }
}
