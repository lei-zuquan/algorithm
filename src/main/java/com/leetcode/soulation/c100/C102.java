package com.leetcode.soulation.c100;

import com.leetcode.soulation.domain.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author:
 * @Date: 2020-10-08 21:20
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
102. 二叉树的层序遍历

给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

示例：
二叉树：[3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]

 */
public class C102 {
    public static void main(String[] args) {
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode node9 = new TreeNode(9);
        TreeNode root = new TreeNode(3, node9, node20);

        C102 c04 = new C102();
        List<List<Integer>> lists = c04.levelOrder(root);
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> integers = lists.get(i);
            System.out.println("\n==============: " + (i+1) + " 层");
            for (int index = 0; index < integers.size(); index++) {
                System.out.print(integers.get(index) + "\t");
            }
        }
    }

    // 层序遍历
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
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
}
