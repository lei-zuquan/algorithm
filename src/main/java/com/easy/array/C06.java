package com.easy.array;

import java.util.*;

/**
 * @Author:
 * @Date: 2020-10-08 9:29
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
两个数组的交集 II

给定两个数组，编写一个函数来计算它们的交集。

示例 1：
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2,2]

示例 2:
输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[4,9]

说明：
输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
我们可以不考虑输出结果的顺序。
进阶：

如果给定的数组已经排好序呢？你将如何优化你的算法？
如果nums1的大小比nums2小很多，哪种方法更优？
如果nums2的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？

 */
public class C06 {
    public static void main(String[] args) {
        C06 c06 = new C06();
        int[] intersect = c06.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        c06.printArray(intersect);

        int[] intersect2 = c06.intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4});
        c06.printArray(intersect2);

        int[] intersect3 = c06.intersect(new int[]{1,1}, new int[]{1,2});
        c06.printArray(intersect3);
    }

    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println("\n============================");
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }



}
