package com.test;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author:
 * @Date: 2020-10-09 19:43
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        HashMap<String, String> a = new HashMap<>();
        HashMap<String, String> b = new HashMap<>();
        a.put("a", "a");
        b = a;
        b.put("b", "b");

        System.out.println(a.get("a"));
        System.out.println(a.get("b"));
        System.out.println("===================");
        System.out.println(b.get("a"));
        System.out.println(b.get("b"));
    }
}
