package com.leetcode.soulation.c100;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author:
 * @Date: 2020-10-15 9:37
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*

116. 填充每个节点的下一个右侧节点指针

给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有next 指针都被设置为 NULL。


示例：
输入：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}

输出：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}

解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。

提示：

你只能使用常量级额外空间。
使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。

 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class C116 {
    public static void main(String[] args) {
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        Node node2 = new Node(2, node4, node5, null);
        Node node3 = new Node(3, node6, node7, null);
        Node root = new Node(1, node2, node3, null);

        C116 c116 = new C116();
        Node newRoot = c116.connect(root);

    }

    public void println(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                System.out.println(poll.val);
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
        }
    }

    // 层序遍历【广度优先算法】
    public Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prevNode = null;
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();

                if (prevNode == null) {
                    prevNode = poll;
                } else {
                    prevNode.next = poll;
                }
                prevNode = poll;

                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }

            prevNode.next = null;
        }

        return root;
    }



    // 层序遍历【广度优先算法】
    public Node connect1(Node root) {
        if (root == null) return null;

        List<List<Node>> res = new LinkedList<>();

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Node> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                list.add(poll);
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }

            res.add(list);
        }

        for (int i = 0; i < res.size(); i++) {
            List<Node> nodes = res.get(i);
            Node prevNode = null;
            for (int index = 0; index < nodes.size(); index++) {
                if (prevNode != null) {
                    prevNode.next = nodes.get(index);
                }
                prevNode = nodes.get(index);
            }
        }

        return root;
    }
}
