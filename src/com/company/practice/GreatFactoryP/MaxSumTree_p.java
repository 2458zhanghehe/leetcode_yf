package com.company.practice.GreatFactoryP;

import com.company.BNtree.IsBST.Node;

public class MaxSumTree_p {

    public static int maxSumTree1(Node head) {
        return process1(head);
    }

    public static int process1(Node cur) {
        if (cur.left == null && cur.right == null) {
            return cur.value;
        }
        int res = 0;
        if (cur.left != null) {
            res = process1(cur.left);
        }
        if (cur.right != null) {
            res = Math.max(res, process1(cur.right));
        }
        return res + cur.value;
    }

    public static int maxS = 0;

    public static int maxSumTree2(Node head) {
        process2(head, 0);
        return maxS;
    }

    public static void process2(Node cur, int already) {
        if (cur.left == null && cur.right == null) {
            maxS = Math.max(maxS, already + cur.value);
            return;
        }
        if (cur.left != null) {
            process2(cur.left, already + cur.value);
        }
        if (cur.right != null) {
            process2(cur.right, already + cur.value);
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
