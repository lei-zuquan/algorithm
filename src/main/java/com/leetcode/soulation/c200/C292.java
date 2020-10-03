package com.leetcode.soulation.c200;

/**
 * @Author:
 * @Date: 2020-10-03 12:35
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
292. Nim 游戏
你和你的朋友，两个人一起玩Nim 游戏：桌子上有一堆石头，每次你们轮流拿掉1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。

你们是聪明人，每一步都是最优解。 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。

 */
public class C292 {
    public static void main(String[] args) {
        C292 c292 = new C292();
        for (int i = 1; i <= 20; i++) {
            System.out.println(c292.canWinNim(i));
        }
    }

    // 如果堆中石头的数量 nn 不能被 44 整除，那么你总是可以赢得 Nim 游戏的胜利。
    // 时间复杂度：O(1)
    // 空间复杂度：O(1)
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
