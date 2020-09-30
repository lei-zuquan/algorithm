package com.leetcode.soulation.domain;

/**
 * @Author:
 * @Date: Created in 11:26 上午 2020/9/30
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
