package com.leetcode.soulation;

import java.util.*;

/**
 * @Author:
 * @Date: 2020-10-02 15:40
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*

给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

示例 1:
输入: [3,2,3]
输出: 3

示例 2:
输入: [2,2,1,1,1,2,2]
输出: 2
 */
public class C169 {
    public static void main(String[] args) {
        C169 c169 = new C169();
        System.out.println(c169.majorityElement(new int[]{3, 2, 3}));
        System.out.println(c169.majorityElement(new int[]{2,2,1,1,1,2,2}));
        System.out.println(c169.majorityElement(new int[]{1}));
        System.out.println(7/2);
    }

    // 先将数组排序，然后取数组长度/2的值，因为从数占用一半以上的位置
    // 时间复杂度：O(logN)
    // 空间复杂度：O(1)
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    // 使用额外空间
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public int majorityElement1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
            } else {
                hashMap.put(nums[i], 1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();

        Map.Entry<Integer, Integer> maxEntry = null;
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            if (maxEntry == null) {
                maxEntry = next;
            } else {
                if (next.getValue() > maxEntry.getValue() ) {
                    maxEntry = next;
                }
            }
        }

        return maxEntry.getKey();
    }


}
