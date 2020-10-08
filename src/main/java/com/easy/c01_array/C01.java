package com.easy.c01_array;

/**
 * @Author:
 * @Date: 2020-10-07 18:02
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*

删除排序数组中的重复项

示例2:
给定 nums = [0,0,1,1,1,2,2,3,3,4],
函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
你不需要考虑数组中超出新长度后面的元素。
 */
public class C01 {
    public static void main(String[] args) {
        C01 c01 = new C01();
        int[] arr = new int[]{1};
        int size = c01.removeDuplicates(arr);
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + "\t");
        }

        System.out.println("\n==================");
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int finishIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[finishIndex]) {
                finishIndex++;
                nums[finishIndex] = nums[i];
            }
        }

        return finishIndex+1;
    }
}
