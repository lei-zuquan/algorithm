package com.easy.c08_number;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author:
 * @Date: 2020-10-08 15:08
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
412. Fizz Buzz
写一个程序，输出从 1 到 n 数字的字符串表示。

1. 如果n是3的倍数，输出“Fizz”；
2. 如果n是5的倍数，输出“Buzz”；
3. 如果n同时是3和5的倍数，输出 “FizzBuzz”。

示例：
n = 15,
返回:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]


 */
public class C01 {
    public static void main(String[] args) {
        C01 c01 = new C01();
        List<String> list = c01.fizzBuzz(1);
        c01.println(list);

        list = c01.fizzBuzz(1);
        c01.println(list);

        list = c01.fizzBuzz(2);
        c01.println(list);

        list = c01.fizzBuzz(3);
        c01.println(list);

        list = c01.fizzBuzz(4);
        c01.println(list);

        list = c01.fizzBuzz(15);
        c01.println(list);
    }

    private void println(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("===========================");
    }

    /*
        1. 如果n是3的倍数，输出“Fizz”；
        2. 如果n是5的倍数，输出“Buzz”；
        3. 如果n同时是3和5的倍数，输出 “FizzBuzz”。
     */
    public List<String> fizzBuzz(int n) {
        List<String> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            boolean isThree = i % 3 == 0;
            boolean isFive = i % 5 == 0;

            if (isThree && !isFive) {
                list.add("Fizz");
            } else if (isFive && !isThree) {
                list.add("Buzz");
            } else if (isThree && isFive) {
                list.add("FizzBuzz");
            } else {
                list.add(i+"");
            }
        }

        return list;
    }
}
