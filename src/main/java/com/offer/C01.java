package com.offer;

import java.lang.reflect.Member;

/**
 * @Author:
 * @Date: 2020-10-07 10:16
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
剑指 Offer 04. 二维数组中的查找
在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

示例:
现有矩阵 matrix 如下：
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
给定 target=5，返回true。
给定target=20，返回false。
限制：
0 <= n <= 1000
0 <= m <= 1000

 */
public class C01 {
    public static void main(String[] args) {
        int[][] arr = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        C01 c01 = new C01();
        System.out.println(c01.findNumberIn2DArray(arr, 5));
        System.out.println(c01.findNumberIn2DArray(arr, 30));
        System.out.println(c01.findNumberIn2DArray(arr, 41));
        System.out.println(c01.findNumberIn2DArray(arr, 0));
        System.out.println(c01.findNumberIn2DArray(arr, 1));

//        int[][] arr2 = new int[][]{
//                {1,2,3,4,5},
//                {6,7,8,9,10},
//                {11,12,13,14,15},
//                {16,17,18,19,20},
//                {21,22,23,24,25}
//        };
        int[][] arr2 = {{1,1}};
        System.out.println(c01.findNumberIn2DArray(arr2, 0));
    }

    // 暴力法
    // 时间复杂度：O(n^2)
    // 空间复杂度：O(1)
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }

    // 线性查找
    // 从二维数组的右上角开始查找。如果当前元素等于目标值，则返回 true。如果当前元素大于目标值，则移到左边一列。如果当前元素小于目标值，则移到下边一行。
    // 时间复杂度：O(n+m)
    // 空间复杂度：O(1)
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int hengPos = matrix[0].length -1;
        int shuPos = 0;

        while (hengPos >= 0 && shuPos < matrix.length) {
            if (matrix[shuPos][hengPos] == target) {
                return true;
            } else if (matrix[shuPos][hengPos] > target) {
                hengPos--;
            } else {
                shuPos++;
            }
        }

        return false;
    }
}
