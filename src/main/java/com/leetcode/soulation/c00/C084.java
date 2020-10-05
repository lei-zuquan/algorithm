package com.leetcode.soulation.c00;

/**
 * @Author:
 * @Date: 2020-10-05 14:11
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
84. 柱状图中最大的矩形
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class C084 {
    public static void main(String[] args) {
        int[] arr = new int[]{2,1,5,6,2,3};
        C084 c084 = new C084();
        int maxArea = c084.largestRectangleArea(arr);
        System.out.println(maxArea);

        System.out.println(c084.largestRectangleArea(new int[]{1}));
        System.out.println(c084.largestRectangleArea(new int[]{0,9}));
        System.out.println(c084.largestRectangleArea(new int[]{2,1,2}));
    }

    // 双指针法
    // 面积最大：由长和高决定，长越长、高越高，则面积最大
    // 使用start、end双指针分别指向数组的头、尾，如果哪边较小则该边向中间移动；
    // 每次移动前记录当前面积并与之前计算的最大面积比较
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        if (heights.length == 1) return heights[0];

        int maxArea = Integer.MIN_VALUE;
        for (int width = heights.length; width >= 1; width--) {
            for (int j = 0; j < heights.length; j++) {
                int minHighIndex = j;
                for (int start = j+1; start < heights.length; start++) {
                    if (heights[start] < heights[minHighIndex]) {
                        minHighIndex = start;
                    }
                }

                int area = width * heights[minHighIndex];
                if (area > maxArea) maxArea = area;
            }
        }

        return maxArea;
    }


}



