package com.leetcode.soulation.c100;

import com.leetcode.soulation.domain.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:
 * @Date: 2020-10-07 14:09
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
108. 将有序数组转换为二叉搜索树
将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。

示例:
给定有序数组: [-10,-3,0,5,9],
一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5

 */
public class C108 {
    public static void main(String[] args) {
        C108 c108 = new C108();
        TreeNode root = c108.sortedArrayToBST(new int[]{-10,-3,0,5,9});

        c108.printByLayer(root);
    }

    public void printByLayer(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                System.out.print(poll.val + "\t");
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
        }
    }

    // 递归法
    // 时间复杂度：O(N)
    // 空间复杂度：O(logN)
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;

        return helper(nums, 0, nums.length-1);
    }

    public TreeNode helper(int[] nums, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) /2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = helper(nums, start, mid-1);
        root.right = helper(nums, mid+1, end);

        return root;
    }
}
