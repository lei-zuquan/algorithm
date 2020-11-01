package com.niuke;

/**
 * @Author:
 * @Date: 2020-11-01 16:31
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 记录输入字符串数据
//        String inputStr = in.nextLine();
//        String[] numStrArr = inputStr.split(",");
//        int[] numArr = new int[numStrArr.length];
//        for (int i = 0; i < numStrArr.length; i++) {
//            numArr[i] = Integer.parseInt(numStrArr[i]);
//        }
//        int total = getTotal(numArr);

        //int total = getTotal(new int[]{1,-5,-6,4,3,6,-2});
        int total = getTotal(new int[]{-100});

        System.out.println(total);
    }

    private static int getTotal(int[] numArr) {
        // 记录当前索引下对应的最大总分
        int[] maxTotal = new int[numArr.length];
        int totalNum = 0;

        for (int i = 0; i < numArr.length; i++) {

            // 如果当前值为小于0的，则需要回忆前3轮总分
            if (numArr[i] < 0) {
                int lastTotal = 0;
                if (i - 3 >= 0) { // 防止数据越界
                    lastTotal = maxTotal[i-3];
                } else {
                    lastTotal = 0;
                }
                int currMax = totalNum + numArr[i]; // 累加负数后
                // 比较前3轮总和，与当前总和
                totalNum = Math.max(lastTotal, currMax);
            } else {
                totalNum = totalNum + numArr[i];
            }

            // 记录当前最大总分
            maxTotal[i] = totalNum;
        }

        return totalNum;
    }


}
