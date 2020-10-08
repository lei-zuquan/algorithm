package com.easy.c04_tree;

import com.leetcode.soulation.domain.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author:
 * @Date: 2020-10-08 21:38
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
public class C05 {
    public static void main(String[] args) {
        C05 c05 = new C05();
        TreeNode root = c05.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});

        List<List<Integer>> lists = c05.printlnByLayer(root);
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> integers = lists.get(i);
            System.out.println("\n=======:" + (i+1) + " 层");

            for (int j = 0; j < integers.size(); j++) {
                System.out.print(integers.get(j) + "\t");
            }
        }
    }

    private List<List<Integer>> printlnByLayer(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
            res.add(list);
        }
        
        return res;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;

        TreeNode root = getSubTree(nums, 0, nums.length -1);
        return root;
    }

    private TreeNode getSubTree(int[] nums, int start, int end) {
        if (start > end) return null;
        //if (start == end) return new TreeNode(nums[start]);

        int mid = start + (end-start) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = getSubTree(nums, start, mid-1);
        root.right = getSubTree(nums, mid+1, end);

        return root;
    }
}
