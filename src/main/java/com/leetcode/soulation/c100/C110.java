package com.leetcode.soulation.c100;

import com.leetcode.soulation.domain.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * @Author:
 * @Date: 2020-10-07 15:52
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
110. 平衡二叉树

给定一个二叉树，判断它是否是高度平衡的二叉树。
本题中，一棵高度平衡二叉树定义为：
一个二叉树每个节点的左右两个子树的高度差的绝对值不超过1。

示例 1:
给定二叉树 [3,9,20,null,null,15,7]

    3
   / \
  9  20
    /  \
   15   7
返回 true 。

示例 2:
给定二叉树 [1,2,2,3,3,null,null,4,4]

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
返回false 。

 */
public class C110 {
    public static void main(String[] args) {
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode node9 = new TreeNode(9);
        TreeNode root = new TreeNode(3, node9, node20);

        C110 c110 = new C110();
        System.out.println(c110.isBalanced(root));


        System.out.println("=======================");
        TreeNode node4_1 = new TreeNode(4);
        TreeNode node4_2 = new TreeNode(4);
        TreeNode node3_1 = new TreeNode(3, node4_1, node4_2);
        TreeNode node3_2 = new TreeNode(3);
        TreeNode node2_1 = new TreeNode(2, node3_1, node3_2);
        TreeNode node2_2 = new TreeNode(2);
        TreeNode root2 = new TreeNode(1, node2_1, node2_2);
        System.out.println(c110.isBalanced(root2));

        System.out.println("========================");
        // [1,2,2,3,null,null,3,4,null,null,4]

    }

    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if(left == -1) return -1;
        int right = recur(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }


}
