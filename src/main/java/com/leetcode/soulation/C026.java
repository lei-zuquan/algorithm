package com.leetcode.soulation;

/*
给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

*/
public class C026 {
    public static void main(String[] args) {
        int[] arr1 = {1,1,2};
        int[] arr2 = {0,0,0,1,1,1,2,2,3,3,4};

        C026 c026 = new C026();
        int size = c026.removeDuplicates(arr1);
        System.out.println(size);
        int size2 = c026.removeDuplicates(arr2);
        System.out.println(size2);
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }


}
