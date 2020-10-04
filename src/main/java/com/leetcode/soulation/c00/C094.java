package com.leetcode.soulation.c00;

import com.leetcode.soulation.domain.TreeNode;

import java.util.*;

/**
 * @Author:
 * @Date: 2020-10-04 17:04
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
94. 二叉树的中序遍历
给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
。
 */
public class C094 {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode node1 = new TreeNode(1, null, node2);

        C094 c094 = new C094();
        List<Integer> integers = c094.inorderTraversal(node1);
        for (int i = 0; i < integers.size(); i++) {
            System.out.print(integers.get(i) + "\t");
        }
        System.out.println();

    }

    // 栈
    // 方法一的递归函数我们也可以用迭代的方式实现，两种方式是等价的，区别在于递归的时候隐式地维护了一个栈，而我们在迭代的时候需要显式地将这个栈模拟出来
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }

        return list;
    }

    // 递归法
    // 中序遍历：先左、再中、再右
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        midGet(root, list);
        return list;
    }

    // 中序遍历：先左、再中、再右
    private void midGet(TreeNode root, List<Integer> list){
        if (root == null) {
            return;
        }

        if (root.left != null) {
            midGet(root.left, list);
        }

        list.add(root.val);

        if (root.right != null) {
            midGet(root.right, list);
        }
    }
}
