package com.leetcode.soulation.c1100;

import java.util.function.IntConsumer;

/**
 * @Author:
 * @Date: 2020-10-12 17:25
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
1116. 打印零与奇偶数
假设有这么一个类：

class ZeroEvenOdd {
  public ZeroEvenOdd(int n) { ... }     // 构造函数
  public void zero(printNumber) { ... }  // 仅打印出 0
  public void even(printNumber) { ... }  // 仅打印出 偶数
  public void odd(printNumber) { ... }   // 仅打印出 奇数
}
相同的一个ZeroEvenOdd类实例将会传递给三个不同的线程：

线程 A 将调用zero()，它只输出 0 。
线程 B 将调用even()，它只输出偶数。
线程 C 将调用odd()，它只输出奇数。
每个线程都有一个printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列010203040506... ，其中序列的长度必须为 2n。


示例 1：
输入：n = 2
输出："0102"
说明：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。

示例 2：
输入：n = 5
输出："0102030405"

 */
public class C1116 {
    private int n;

    public C1116(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

    }

    public void even(IntConsumer printNumber) throws InterruptedException {

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {

    }

    public static void main(String[] args) throws Exception {
        C1116 c1116 = new C1116(1245785160);

        new Thread() {
            public void run() {

                try {
                    //c1116.zero();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread() {
            public void run() {
                try {
                    //c1116.odd();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread() {
            public void run() {
                try {
                    //c1116.even();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
