package com.leetcode.soulation.c700;

import com.leetcode.soulation.domain.TreeNode;

/**
 * @Author:
 * @Date: Created in 10:39 上午 2020/9/30
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
### 701. 二叉搜索树中的插入操作。给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。
返回插入后二叉搜索树的根节点。 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。

 */
public class C701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(5, null, null);
        }

        TreeNode currNode = root;
        while (currNode != null) {
            if (val > currNode.val) {
                if (currNode.right == null) {
                    TreeNode bstNode = new TreeNode(val, null, null);
                    currNode.right = bstNode;
                    break;
                } else {
                    currNode = currNode.right;
                }
            } else if (val == currNode.val) {
                 break;
            } else {
                if (currNode.left == null) {
                    TreeNode bstNode = new TreeNode(val, null, null);
                    currNode.left = bstNode;
                    break;
                }
                currNode = currNode.left;
            }
        }

        return root;
    }

    public static void printlnByMid(TreeNode root){
        if (root == null) {
            return;
        }

        if (root.left != null) {
            printlnByMid(root.left);
        }

        System.out.println(root.val);

        if (root.right != null) {
            printlnByMid(root.right);
        }

    }

    public static void main(String[] args) {
        TreeNode bstNode1 = new TreeNode(1, null, null);
        TreeNode bstNode3 = new TreeNode(3, null, null);
        TreeNode bstNode2 = new TreeNode(2, bstNode1, bstNode3);

        TreeNode bstNode7 = new TreeNode(7, null, null);

        TreeNode root = new TreeNode(4, bstNode2, bstNode7);

        C701 c701 = new C701();
        root = c701.insertIntoBST(root, 5);



        printlnByMid(root);
    }
}
