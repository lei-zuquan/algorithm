package com.leetcode.soulation;

/**
 * @Author:
 * @Date: 2020-10-01 22:52
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
给定一个数组，它的第i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。

注意：你不能在买入股票前卖出股票。

示例 1:
输入: [7,1,5,3,6,4]
输出: 5

解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。

示例 2:
输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

 */
public class C121 {
    public static void main(String[] args) {
        C121 c121 = new C121();
        int[] prices1 = {7,1,5,3,6,4};
        int[] prices2 = {7,6,4,3,1};
        System.out.println(c121.maxProfit(prices1));
        System.out.println(c121.maxProfit(prices2));

        System.out.println("==================");
        int[] prices = {7,2,3,4,1};
        System.out.println(c121.maxProfit(prices));
        System.out.println("==================");
        int[] prices22 = {7,1,5,3,6,4,0,8};
        System.out.println(c121.maxProfit(prices22));
    }

    // 核心思想：向前探寻下一次最低价格，如果最低价格后面的收益更大，则更新收益
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        // 7,1,5,3,6,4,0,8
        // 7,6,4,3,1
        int lowIndex = 0; // 默认第一个数据为最低价格
        int nextLowerIndex = 0; // 向前探寻下一个最低价格
        int maxIndex = 0; // 最高价格下标
        int length = prices.length; // 数组长度
        int maxProfit = 0; // 最大收益
        for (int i = 1; i < length; i++) {
            // 如果当前的价格比之前找到的最低价还低，则更新最低价
            if (prices[i] < prices[nextLowerIndex]) {
                nextLowerIndex = i;
            }
            if (prices[i] > prices[maxIndex]) {
                maxIndex = i;
            }
            // 如果当前价格比下一次最低价格的收益更高，则更新收益数据
            if (nextLowerIndex > lowIndex) {
                if (prices[i] - prices[nextLowerIndex] > maxProfit) {
                    lowIndex = nextLowerIndex;
                    maxIndex = i;
                }
            }

            maxProfit = prices[maxIndex] - prices[lowIndex];
        }

        if (maxProfit <= 0) {
            return 0;
        } else {
            return maxProfit;
        }
    }
}
