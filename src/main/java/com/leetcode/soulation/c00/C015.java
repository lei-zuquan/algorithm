//package com.leetcode.soulation.c00;
//
//import java.util.*;
//import java.util.zip.CheckedOutputStream;
//
///**
// * @Author:
// * @Date: 2020-10-03 20:47
// * @Version: 1.0
// * @Modified By:
// * @Description:
// */
///*
//15. 三数之和
//给你一个包含 n 个整数的数组nums，
//判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
//
//注意：答案中不可以包含重复的三元组。
//
// */
//public class C015 {
//    public static void main(String[] args) {
//        int[] arr = {-1, 0, 1, 2, -1, -4};
//
//        C015 c015 = new C015();
//        List<List<Integer>> lists = c015.threeSum(arr);
//        for (int i = 0; i < lists.size(); i++) {
//            List<Integer> list = lists.get(i);
//            for (Integer integer : list) {
//                System.out.print(integer + "\t");
//            }
//            System.out.println();
//            System.out.println("==========================");
//        }
//    }
//
//    public List<List<Integer>> threeSum(int[] nums) {
//        HashMap<String, Integer> hashMap = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                if (i == j) continue;
//
//                int other = 0 - nums[i] - nums[j];
//                for (int foundIndex = 0; foundIndex < nums.length; foundIndex++) {
//                    if (foundIndex == i || foundIndex == j) {
//                        continue;
//                    }
//                    if (nums[foundIndex] == other) {
//                        String key = getThreeNumOrderStr(nums[i], nums[j], other);
//                        if (!hashMap.containsKey(key)) {
//                            hashMap.put(key, 0);
//                        }
//                    }
//                }
//            }
//        }
//
//        Iterator<Map.Entry<String, Integer>> iterator = hashMap.entrySet().iterator();
//        List<List<Integer>> totalList = new ArrayList<>();
//        while (iterator.hasNext()) {
//            Map.Entry<String, Integer> next = iterator.next();
//            String key = next.getKey();
//            String[] split = key.split("_");
//            List<Integer> list = new ArrayList<>();
//            for (int i = 0; i < split.length; i++) {
//                int parseInt = Integer.parseInt(split[i]);
//                list.add(parseInt);
//            }
//            totalList.add(list);
//        }
//
//        return totalList;
//    }
//
//    public String getThreeNumOrderStr(int first, int second, int third) {
//        if (first <= second && second <= third) {
//            return first + "_" + second + "_" + third;
//        } else if (first <= third && first <= second) {
//            return first + "_" + third + "_" + second;
//        } else if (second <= first && first <= third) {
//            return second + "_" + first + "_" + third;
//        } else if (second <= third && third <= first) {
//            return second + "_" + third + "_" + first;
//        } else if (third <= second && second <= first) {
//            return third + "_" + second + "_" + first;
//        } else {
//            return third + "_" + first + "_" + second;
//        }
//    }
//
//}
