package com.leetcode.soulation.c100;

import com.leetcode.soulation.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author:
 * @Date: Created in 3:53 下午 2020/10/6
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
101. 对称二叉树
给定一个二叉树，检查它是否是镜像对称的。

 */
public class C101 {
    public static void main(String[] args) {
        // 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
        TreeNode l3Node3_1 = new TreeNode(3, null, null);
        TreeNode l3Node4_1 = new TreeNode(4, null, null);
        TreeNode l3Node3_2 = new TreeNode(3, null, null);
        TreeNode l3Node4_2 = new TreeNode(4, null, null);

        TreeNode l2Node2_1 = new TreeNode(2, l3Node3_1, l3Node4_1);
        TreeNode l2Node2_2 = new TreeNode(2, l3Node3_2, l3Node4_2);

        TreeNode l1Node = new TreeNode(1, l2Node2_1, l2Node2_2);

        C101 c101 = new C101();
        System.out.println(c101.isSymmetric(l1Node));


        TreeNode o2l3Node3_1 = new TreeNode(3, null, null);
        TreeNode o2l3Node3_2 = new TreeNode(3, null, null);
        TreeNode o2l2Node2_1 = new TreeNode(2, null, o2l3Node3_1);
        TreeNode o2l2Node2_2 = new TreeNode(2, null, o2l3Node3_2);
        TreeNode o2l2Node1 = new TreeNode(1, o2l2Node2_1, o2l2Node2_2);
        System.out.println(c101.isSymmetric(o2l2Node1));

        System.out.println("=========");
        System.out.println(c101.isSymmetric(new TreeNode(1)));
    }


    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }


    public boolean isSymmetric2(TreeNode root) {
        return check(root, root);
    }

    public boolean check2(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }
}
