package com.company.BNtree;

//左97
public class MaxSumTree {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int v) {
            val = v;
        }
    }

    //二叉树递归套路，向左树要最大值，向右树要最大值
    public static int maxSumTree1(Node head) {
        return process1(head);
    }

    public static int process1(Node cur) {
        if (cur.left == null && cur.right == null) {
            return cur.val;
        }
        int res = 0;
        if (cur.left != null) {
            res = process1(cur.left);
        }
        if (cur.right != null) {
            res = Math.max(res, process1(cur.right));
        }
        return res + cur.val;
    }

    public static int maxS = Integer.MIN_VALUE;

    public static int maxSumTree2(Node head) {
        process2(head, 0);
        return maxS;
    }

    public static void process2(Node cur, int already) {
        if (cur.left == null && cur.right == null) {
            maxS = Math.max(maxS, already + cur.val);
        }
        if (cur.left != null) {
            process2(cur.left, already + cur.val);
        }
        if (cur.right != null) {
            process2(cur.right, already + cur.val);
        }
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        System.out.println(maxSumTree1(head));
        System.out.println(maxSumTree2(head));
    }
}
