package com.leetcode.soulation;

import com.leetcode.soulation.domain.TreeNode;

/**
 * @Author:
 * @Date: 2020-10-01 22:37
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明:叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度3 。

 */

public class C104 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        root.left = node9;
        root.right = node20;

        node20.left = node15;
        node20.right = node7;

        TreeNode node6 = new TreeNode(6);
        node7.left = node6;

        C104 c104 = new C104();
        int maxDepth = c104.maxDepth(root);
        System.out.println(maxDepth);
    }

    // 时间复杂度 O(n)
    // 空间复杂度 O(height)
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 查询左子节点最大深度
        int leftDepth = maxDepth(root.left);

        // 查询左子节点最大深度
        int rightDepth = maxDepth(root.right);

        // 然后取左、右字节点最大深度 + 1
        if (leftDepth >= rightDepth) {
            return leftDepth + 1;
        } else {
            return rightDepth + 1;
        }
    }
}
