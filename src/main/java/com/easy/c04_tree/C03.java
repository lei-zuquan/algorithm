package com.easy.c04_tree;

import com.leetcode.soulation.domain.TreeNode;

/**
 * @Author:
 * @Date: 2020-10-08 17:53
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
剑指 Offer 28. 对称的二叉树
给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树[1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3


但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:
    1
   / \
  2   2
   \   \
   3    3

进阶：
你可以运用递归和迭代两种方法解决这个问题吗？

 */
public class C03 {
    public static void main(String[] args) {

    }

    public void println(TreeNode root) {
        if (root == null) return;

        System.out.println(root.val);

        println(root.left);

        println(root.right);
    }

    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }
    boolean recur(TreeNode L, TreeNode R) {
        if(L == null && R == null) return true;
        if(L == null || R == null || L.val != R.val) return false;

        return recur(L.left, R.right) && recur(L.right, R.left);
    }
}
