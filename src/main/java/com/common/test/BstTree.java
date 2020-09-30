package com.common.test;

import com.leetcode.soulation.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:
 * @Date: Created in 5:29 下午 2020/9/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 题目：中序遍历二叉搜索树

public class BstTree {



    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
//        TreeNode l1Left = new TreeNode(3);
//        TreeNode l1Right = new TreeNode(7);
//        root.left = l1Left;
//        root.right = l1Right;
//
//        TreeNode l2Left1 = new TreeNode(2);
//        TreeNode l2Right1 = new TreeNode(4);
//        l1Left.left = l2Left1;
//        l1Left.right = l2Right1;
//
//        TreeNode l2Left2 = new TreeNode(6);
//        TreeNode l2Right2 = new TreeNode(8);
//        l1Right.left = l2Left2;
//        l1Right.right = l2Right2;
//

        // 中序输出
        println(root);
        List<Integer> list = new ArrayList<>();
        println(root, list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private static void println(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            println(root.left);
        }

        System.out.println(root.val);

        if (root.right != null) {
            println(root.right);
        }
    }


    private static void println(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        if (root.left != null) {
            println(root.left, list);
        }

        list.add(root.val);

        if (root.right != null) {
            println(root.right, list);
        }
    }
}
