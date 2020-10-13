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
    public ZeroEvenOdd(int n) { ... }      // 构造函数
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

    //private volatile int state = 0;
    //private volatile boolean nextPrintOdd = true;
    private int state = 0;
    private boolean nextPrintOdd = true;


    public C1116(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (state != 0) {
                Thread.yield();
            }
            printNumber.accept(0);
            if (nextPrintOdd) {
                state = 1;
            } else {
                state = 2;
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i+=2) {
            while (state != 2) {
                Thread.yield();
            }
            printNumber.accept(i);
            nextPrintOdd = true;
            state = 0;
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {

        for (int i = 1; i <= n; i+=2) {
            while (state != 1) {
                Thread.yield();
            }
            printNumber.accept(i);
            nextPrintOdd = false;
            state = 0;
        }
    }



    public static void main(String[] args) throws Exception {
        C1116 c1116 = new C1116(30);

        Thread thread1 = new Thread() {
            public void run() {

                try {
                    IntConsumerImpl intConsumer = new IntConsumerImpl();
                    c1116.zero(intConsumer);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread1.setName("printZero");

        Thread thread2 = new Thread() {
            public void run() {
                try {
                    IntConsumerImpl intConsumer = new IntConsumerImpl();
                    c1116.even(intConsumer);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread2.setName("printEven");

        Thread thread3 = new Thread() {
            public void run() {
                try {
                    IntConsumerImpl intConsumer = new IntConsumerImpl();
                    c1116.odd(intConsumer);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread3.setName("printOdd");


        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("\n===========================");
    }


}

class IntConsumerImpl implements IntConsumer {

    @Override
    public void accept(int value) {
        System.out.print(value);
    }
}

