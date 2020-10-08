package com.easy.c04_tree;

import com.leetcode.soulation.domain.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author:
 * @Date: 2020-10-08 16:49
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
98. 验证二叉搜索树
给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。

示例1:
输入:
    2
   / \
  1   3
输出: true

示例2:
输入:
    5
   / \
  1   4
    / \
   3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
    根节点的值为 5 ，但是其右子节点值为 4 。

 */
public class C02 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode root = new TreeNode(2, node1, node3);
        C02 c02 = new C02();
        System.out.println(c02.isValidBST(root));

        System.out.println("==================================");

        TreeNode t2Node3 = new TreeNode(3);
        TreeNode t2Node6 = new TreeNode(6);
        TreeNode t2Node4 = new TreeNode(4, t2Node3, t2Node6);
        TreeNode t2Node1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(5, t2Node1, t2Node4);
        System.out.println(c02.isValidBST(root2));

        System.out.println("==================================");
        System.out.println(c02.isValidBST(new TreeNode(-2147483648)));
    }

    // 中序遍历法
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> Stack = new Stack<>();
        Integer lastMinValue = null;
        while (root != null || !Stack.isEmpty()) {
            while (root != null) {
                Stack.push(root);
                root = root.left;
            }
            root = Stack.pop();
            if (lastMinValue != null && root.val <= lastMinValue) {
                return false;
            }
            lastMinValue = root.val;

            root = root.right;
        }
        return true;
    }

    public boolean isValidBST1(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        getValueByMid(root, list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i-1)) return false;
        }
        return true;
    }



    private void getValueByMid(TreeNode root, List<Integer> list) {
        if (root == null) return;

        getValueByMid(root.left, list);

        list.add(root.val);

        getValueByMid(root.right, list);
    }


}
