package com.leetcode.soulation;

import com.leetcode.soulation.domain.TreeNode;

/**
 * @Author:
 * @Date: 2020-10-03 9:43
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
235. 二叉搜索树的最近公共祖先
给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

 */
public class C235 {
    public static void main(String[] args) {
        C235 c235 = new C235();
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node0 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4, node3, node5);
        TreeNode node2 = new TreeNode(2, node0, node4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node8 = new TreeNode(8, node7, node9);
        TreeNode root = new TreeNode(6, node2, node8);


        TreeNode commonAncestor1 = c235.lowestCommonAncestor2(root, node2, node8);
        System.out.println(commonAncestor1.val);
        TreeNode commonAncestor2 = c235.lowestCommonAncestor2(root, node2, node4);
        System.out.println(commonAncestor2.val);

    }

    // 先中、再左、再右探寻法(递归实现)
    // 先判断当前root是否与p、q相等，如果相等则返回root;
    // 否则判断p、q是否都在左侧，是则继续递归左侧；
    // 否则判断p、q是否都在右侧，是则继续递归右侧;
    // 时间复杂度：O(logN)
    // 空间复杂度：O(1)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == root || q == root) {
            return root;
        }

        // 二叉搜索树满足，左子节点都小于根节点；右子节点都大于根节点
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }

    // 先中、再左、再右探寻法(非递归实现)
    // 时间复杂度：O(logN)
    // 空间复杂度：O(1)
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (p == root || q == root) {
            return root;
        }

        TreeNode currNode = root;
        // 二叉搜索树满足，左子节点都小于根节点；右子节点都大于根节点
        while (currNode != null) {
            if (p.val < currNode.val && q.val < currNode.val) {
                currNode = currNode.left;
            } else if (p.val > currNode.val && q.val > currNode.val) {
                currNode = currNode.right;
            } else {
                return currNode;
            }
        }

        return root;
    }
}
