package com.niuke.list;

import com.leetcode.soulation.domain.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author:
 * @Date: Created in 3:41 下午 2020/10/9
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
分别按照二叉树先序，中序和后序打印所有的节点。
 */
public class C03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    }
    /**
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders (TreeNode root) {
        int[][] res = new int[3][];

        // 先序：根、左、右
        List<Integer> list = new LinkedList<>();
        getByPrev(root, list);
        int[] prevArr = getArrayFromList(list);
        res[0] = prevArr;

        // 中序：左、根、右
        list.clear();
        getByMid(root, list);
        int[] midArr = getArrayFromList(list);
        res[1] = midArr;

        // 后序：左、右、根
        list.clear();
        getByLast(root, list);
        int[] lastArr = getArrayFromList(list);
        res[2] = lastArr;

        return res;
    }

    private int[] getArrayFromList(List<Integer> list) {
        int size = list.size();
        int[] res = new int[size];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    private void getByPrev(TreeNode root, List<Integer> list) {
        if (root == null) return;

        list.add(root.val);

        getByPrev(root.left, list);
        getByPrev(root.right, list);
    }

    private void getByMid(TreeNode root, List<Integer> list) {
        if (root == null) return;

        getByMid(root.left, list);

        list.add(root.val);

        getByMid(root.right, list);
    }

    private void getByLast(TreeNode root, List<Integer> list) {
        if (root == null) return;

        getByLast(root.left, list);
        getByLast(root.right, list);

        list.add(root.val);
    }


}
