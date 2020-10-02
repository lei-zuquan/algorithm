package com.leetcode.soulation;

import java.util.*;

/**
 * @Author:
 * @Date: 2020-10-02 8:12
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
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
public class C136 {
    public static void main(String[] args) {
        C136 c136 = new C136();
        int[] arr1 = {2,2,1};
        System.out.println(c136.singleNumber(arr1));
        System.out.println("===============================");
        int[] arr2 = {4,1,2,1,2};
        System.out.println(c136.singleNumber(arr2));
    }

    /*
        方法二：异或（XOR）
            1.如果我们对 0和二进制位做XOR运算，得到的仍然是这个二进制位
            2.如果我们对相同的二进制位做XOR运算，返回的结果是0
            3.XOR满足交换律和结合律
     */
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int i = 0; i < nums.length; i++) {
            single ^= nums[i];
        }

        return single;
    }

    // 通过使用外部存储空间解决
    // 方法1：记录次数
    // 遍历数组：同时建立哈希表来记录每个数字在数组中出现的次数
    // 遍历哈希表找到只出现一次的数字
    // 在遍历数组时记录出现的数字：如果当前数字没有出现过则将数字记下，如果当前数字已经出现过了则将其从记录中删去
    // 最后记录中剩下的数字就是只出现一次的数字
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public int singleNumber1(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.remove(nums[i]);
            } else {
                hashMap.put(nums[i], nums[i]);
            }
        }

        if (hashMap.size() == 1) {
            Set<Integer> integers = hashMap.keySet();
            Iterator<Integer> iterator = integers.iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                return next;
            }
        }
        return -1;
    }
}
