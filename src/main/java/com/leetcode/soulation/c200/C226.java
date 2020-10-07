package com.leetcode.soulation.c200;

import com.leetcode.soulation.domain.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author:
 * @Date: 2020-10-07 16:40
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
226. 翻转二叉树
翻转一棵二叉树

     4
   /   \
  2     7
 / \   / \
1   3 6   9

 */
public class C226 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1, null, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, node1, node3);

        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);
        TreeNode node7 = new TreeNode(7, node6, node9);
        TreeNode root = new TreeNode(4, node2, node7);

        C226 c226 = new C226();
        TreeNode newRoot = c226.invertTree(root);
        List<List<Integer>> listList = c226.getLayer(newRoot);
        for (int i = 0; i < listList.size(); i++) {
            List<Integer> integers = listList.get(i);
            System.out.println("============== 第 " + (i+1) + " 层");
            for (int index = 0; index < integers.size(); index++) {
                System.out.print(integers.get(index) + "\t");
            }
        }
    }

    // 层序遍历
    public List<List<Integer>> getLayer(TreeNode root) {
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

    // 递归法
    // 从根节点左、右子节点翻转，然后再翻转左节子点树、再翻转右子节点树
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode right = root.right;
        TreeNode left = root.left;
        root.left = right;
        root.right = left;

        invertTree(root.left);

        invertTree(root.right);

        return root;
    }
}
