package com.leetcode.soulation.c100;

import com.leetcode.soulation.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author:
 * @Date: 2020-10-07 13:42
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
107. 二叉树的层次遍历 II
给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其自底向上的层次遍历为：

[
  [15,7],
  [9,20],
  [3]
]
*/
public class C107 {
    public static void main(String[] args) {
        TreeNode l3Node15 = new TreeNode(15, null, null);
        TreeNode l3Node7 = new TreeNode(7, null, null);
        TreeNode l2Node20 = new TreeNode(20, l3Node15, l3Node7);
        TreeNode l2Node9 = new TreeNode(9, null, null);
        TreeNode l1Node3 = new TreeNode(3, l2Node9, l2Node20);

        C107 c107 = new C107();
        List<List<Integer>> lists = c107.levelOrderBottom(l1Node3);
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> integers = lists.get(i);
            System.out.println("======== 第 " + (i+1) + " 层");
            for (int j = 0; j < integers.size(); j++) {
                System.out.print(integers.get(j) + "\t");
            }
            System.out.println();
        }
    }

    // 广度优先搜索
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size(); // 记录当前层有多少个节点
            for (int i = 0; i < size; i++) { // 遍历当前层的所以节点，并将下一层节点放入队列中
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
            // 将当前层节点信息放在结果队列中
            res.add(list);
        }

        return res;
    }


    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> levelOrder = new LinkedList<>();
        if (root == null) {
            return levelOrder;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                TreeNode left = node.left, right = node.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            levelOrder.add(0, level);
        }
        return levelOrder;

    }
}
