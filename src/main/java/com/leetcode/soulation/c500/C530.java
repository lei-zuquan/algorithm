package com.leetcode.soulation.c500;

import com.leetcode.soulation.domain.TreeNode;

import java.util.Stack;

/**
 * @Author:
 * @Date: 2020-10-12 8:41
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
530. 二叉搜索树的最小绝对差
给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。

示例：

输入：

   1
    \
     3
    /
   2

输出：
1

解释：
最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。

提示：
树中至少有 2 个节点。
本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同

 */
public class C530 {
    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(21);
        TreeNode node3 = new TreeNode(25, node2, null);
        TreeNode root = new TreeNode(1, null, node3);

        C530 c530 = new C530();
        System.out.println(c530.getMinimumDifference(root));
    }

    // 中序遍历【非递归实现】
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public int getMinimumDifference(TreeNode root) {
        int minValue = Integer.MAX_VALUE;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prevNode = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (prevNode != null) {
                int abs = Math.abs(root.val - prevNode.val);
                if (abs < minValue) minValue = abs;
            }

            prevNode = root;

            root = root.right;
        }

        return minValue;
    }


}
