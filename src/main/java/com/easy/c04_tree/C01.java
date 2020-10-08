package com.easy.c04_tree;

import com.leetcode.soulation.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:
 * @Date: 2020-10-08 10:37
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
104. 二叉树的最大深度
给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点

示例：
给定二叉树 [3,9,20,null,null,15,7]，
    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度3 。


 */
public class C01 {
    public static void main(String[] args) {
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode node9 = new TreeNode(9);
        TreeNode root = new TreeNode(3, node9, node20);

        C01 c01 = new C01();
        int maxDepth = c01.maxDepth(root);
        System.out.println("maxDepth:" + maxDepth);

        c01.midPrint(root);
    }

    // 递归法
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        if (root != null && root.left == null && root.right == null) return 1;

        int leftMaxDepth = maxDepth1(root.left) + 1;
        int rightMaxDepth = maxDepth1(root.right) + 1;

        int maxDepth = leftMaxDepth > rightMaxDepth ? leftMaxDepth : rightMaxDepth;

        return maxDepth;
    }

    // 广度优先
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
            maxDepth++;
        }

        return maxDepth;
    }

    public void midPrint(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        while (root != null || !queue.isEmpty()) {
            while (root != null) {
                queue.offer(root);
                root = root.left;
            }
            root = queue.poll();
            System.out.print(root.val + "\t");

            root = root.right;
        }
    }
}
