package com.leetcode.soulation.c1100;

import java.util.concurrent.Semaphore;

/**
 * @Author:
 * @Date: 2020-10-12 16:06
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*

1115. 交替打印FooBar

我们提供一个类：

class FooBar {
  public void foo() {
    for (int i = 0; i < n; i++) {
        print("foo");
    }
  }

  public void bar() {
    for (int i = 0; i < n; i++) {
        print("bar");
    }
  }
}

两个不同的线程将会共用一个 FooBar实例。其中一个线程将会调用foo()方法，另一个线程将会调用bar()方法。
请设计修改程序，以确保 "foobar" 被输出 n 次。

示例 1:
输入: n = 1
输出: "foobar"
解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。

示例 2:
输入: n = 2
输出: "foobarfoobar"
解释: "foobar" 将被输出两次。

 */
public class C1115 {
    private int n;
    // 模拟共享竞争资源
    private Semaphore semaphorePrintFoo;
    private Semaphore semaphorePrintBar;

    public C1115(int n) {
        this.n = n;
        semaphorePrintFoo = new Semaphore(1);
        semaphorePrintBar = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphorePrintFoo.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            semaphorePrintBar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphorePrintBar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            semaphorePrintFoo.release();
        }
    }



    public static void main(String[] args) throws InterruptedException {
        C1115 fb = new C1115(4);

        new Thread() {
            public void run() {
                try {
                    fb.foo(new Runnable() {

                        @Override
                        public void run() {
                            System.out.println("foo");
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
                    fb.bar(new Runnable() {

                        @Override
                        public void run() {
                            System.out.println("bar");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
