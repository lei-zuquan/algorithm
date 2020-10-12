package com.leetcode.soulation.c1100;

import java.util.concurrent.Semaphore;

/**
 * @Author:
 * @Date: 2020-10-12 16:53
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
1114. 按序打印

我们提供了一个类：

public class Foo {
    public void first() { print("first"); }
    public void second() { print("second"); }
    public void third() { print("third"); }
}

三个不同的线程将会共用一个Foo实例。
线程 A 将会调用 first() 方法
线程 B 将会调用second() 方法
线程 C 将会调用 third() 方法
请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。


示例 1:
输入: [1,2,3]
输出: "firstsecondthird"
解释:
有三个线程会被异步启动。
输入 [1,2,3] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 second() 方法，线程 C 将会调用 third() 方法。
正确的输出是 "firstsecondthird"。

示例 2:
输入: [1,3,2]
输出: "firstsecondthird"
解释:
输入 [1,3,2] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 third() 方法，线程 C 将会调用 second() 方法。
正确的输出是 "firstsecondthird"。

提示：

尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
你看到的输入格式主要是为了确保测试的全面性。

 */
public class C1114 {

    private Semaphore first;
    private Semaphore second;
    private Semaphore third;

    public C1114() {
        first = new Semaphore(1);
        second = new Semaphore(0);
        third = new Semaphore(0);
    }



    public void first(Runnable printFirst) throws InterruptedException {
        first.acquire();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        second.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        second.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        third.release();

    }

    public void third(Runnable printThird) throws InterruptedException {
        third.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        first.release();
    }

    public static void main(String[] args) {
        C1114 c1114 = new C1114();
        new Thread() {
            public void run() {
                try {
                    c1114.first(new Runnable() {

                        @Override
                        public void run() {
                            System.out.println("first");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            public void run() {
                try {
                    c1114.second(new Runnable() {

                        @Override
                        public void run() {
                            System.out.println("second");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            public void run() {
                try {
                    c1114.third(new Runnable() {

                        @Override
                        public void run() {
                            System.out.println("third");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
