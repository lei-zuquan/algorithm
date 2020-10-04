package com.leetcode.soulation.c00;

import com.leetcode.soulation.domain.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author:
 * @Date: 2020-10-04 18:50
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

 */
public class C098 {
    public static void main(String[] args) {
        TreeNode l1Node1 = new TreeNode(1);
        TreeNode l1Node3 = new TreeNode(3);
        TreeNode l1Node2 = new TreeNode(2, l1Node1, l1Node3);
        C098 c098 = new C098();
        System.out.println(c098.isValidBST(l1Node2));

        // [5,1,4,null,null,3,6]
        TreeNode l2Node3 = new TreeNode(3);
        TreeNode l2Node6 = new TreeNode(6);
        TreeNode l2Node4 = new TreeNode(4, l2Node3, l2Node6);
        TreeNode l2Node1 = new TreeNode(1);
        TreeNode l2Node5 = new TreeNode(5, l2Node1, l2Node4);
        System.out.println(c098.isValidBST(l2Node5));

        TreeNode l3Node1 = new TreeNode(1);
        TreeNode root = new TreeNode(1, l3Node1, null);
        System.out.println(c098.isValidBST(root));

        // [10,5,15,null,null,6,20]
        TreeNode l4Node6 = new TreeNode(6);
        TreeNode l4Node20 = new TreeNode(20);
        TreeNode l4Node15 = new TreeNode(15, l4Node6, l4Node20);
        TreeNode l4Node5 = new TreeNode(5);
        TreeNode l4Node10 = new TreeNode(10, l4Node5, l4Node15);
        System.out.println(c098.isValidBST(l4Node10));
    }


    // 非递归中序遍历
    // 采用中序遍历能将二叉搜索树转换为从小到大的顺序访问；可以前后两两比较
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double lastVal = -Double.MAX_VALUE;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (lastVal >= root.val) {
                return false;
            }

            lastVal = root.val;
            root = root.right;
        }

        return true;
    }

    // 中序遍历输出为一个链表，并对链表顺序访问大小
    // 时间复杂度：O(2n)
    // 空间复杂度：O(n)
    public boolean isValidBST2(TreeNode root) {
        List<Integer> list = getValueByMid(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i-1) >= list.get(i)) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> getValueByMid(TreeNode root) {
        List<Integer> list = new ArrayList<>();
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
}
