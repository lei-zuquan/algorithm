package com.niuke.a01_huawei;

/**
 * @Author:
 * @Date: Created in 4:19 下午 2020/10/9
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
import java.util.Scanner;


// 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
public class C01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();
        String inputChar = sc.nextLine().toLowerCase();
        char findChar = inputChar.charAt(0);

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == findChar) {
                count++;
            }
        }

        System.out.println(count);
    }
}
