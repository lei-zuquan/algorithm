package com.offer;

/**
 * @Author:
 * @Date: 2020-10-22 11:16
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
剑指 Offer 20. 表示数值的字符串

请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。

 */
public class C08 {
    public static void main(String[] args) {
        C08 c08 = new C08();
        System.out.println(c08.isNumber("+100"));
        System.out.println(c08.isNumber("5e2"));
        System.out.println(c08.isNumber("-123"));
        System.out.println(c08.isNumber("3.1416"));
        System.out.println(c08.isNumber("-1E-16"));
        System.out.println(c08.isNumber("0123"));
        System.out.println(c08.isNumber("1 "));
        System.out.println(c08.isNumber(".1"));
        System.out.println(c08.isNumber("32.e-80123"));
        System.out.println("================================");
        System.out.println(c08.isNumber("12e"));
        System.out.println(c08.isNumber("1a3.14"));
        System.out.println(c08.isNumber("+-5"));
        System.out.println(c08.isNumber("12e+5.4"));
        System.out.println(c08.isNumber("."));
        System.out.println(c08.isNumber("e9"));
        System.out.println(c08.isNumber(" "));
        System.out.println(c08.isNumber(". 1"));

    }

    public boolean isNumber(String s) {
        s = s.trim();
        boolean havePlus = false;
        boolean haveNeg = false;
        boolean haveE = false;
        boolean haveNum = false;
        int pointNum = 0;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar == '-') {
                if (haveNum) return false;
                if (havePlus) return false;
                if (pointNum>=1) return false;
                haveNeg = true;
                continue;
            }
            if (currChar == '+') {
                if (haveNum) return false;
                if (haveNeg) return false;
                if (pointNum>=1) return false;
                havePlus = true;
                continue;
            }
            if (currChar == '.') {
                if (haveE) return false;
                pointNum++;
                if (pointNum >= 2) return false;
                continue;
            }
            if (currChar == 'e' || currChar == 'E') {
                if (haveE) return false;
                if (!haveNum) return false;
                haveE = true;
                haveNum = false;
                pointNum = 0;
                continue;
            }
            if (currChar < '0' || currChar > '9') {
                if (currChar == ' ') return false;
                return false;
            } else {
                haveNum = true;
            }
        }

        if (!haveNum) return false;

        return true;
    }
}
