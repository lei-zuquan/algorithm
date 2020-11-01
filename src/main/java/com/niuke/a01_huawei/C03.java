package com.niuke.a01_huawei;

/**
 * @Author:
 * @Date: 2020-11-01 15:41
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
import java.util.Scanner;
public class C03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer value = Integer.parseInt(sc.next());
        String str = value + "";
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length-1; i >= 0; i--) {
            sb.append(chars[i]);
        }

        System.out.println(sb.toString());
    }
}
