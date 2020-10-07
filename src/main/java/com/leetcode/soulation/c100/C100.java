package com.leetcode.soulation.c100;

import com.leetcode.soulation.domain.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * @Author:
 * @Date: 2020-10-07 12:32
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
100. 相同的树


 */
public class C100 {
    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(0, null, null);
        TreeNode node2 = new TreeNode(2, node0, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node1 = new TreeNode(1, node2, node3);
        C100 c100 = new C100();
        System.out.println(c100.isSameTree(node1, node2));
    }

    // 遍历法
    // 采用前序遍历，逐一比较当前元素是否相同
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p != null && q == null) return false;
        if (p == null && q != null) return false;

        if (p.val != q.val) {
            return false;
        }

        if (!isSameTree(p.left, q.left)) return false;

        if (!isSameTree(p.right, q.right)) return false;

        return true;
    }


}
