package com.company.BNtree;

import java.util.Map;

// leetcode 543 树形dp,递归套路  左67
public class TreeMaxDis {

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int v) {
            value = v;
        }
    }

    public static class Info {
        int maxDis;
        int height;

        public Info(int m, int h) {
            maxDis = m;
            height = h;
        }
    }

    public static int treeMaxDis(Node head) {
        return process(head).maxDis;
    }

    public static Info process(Node head) {
        if (head == null) {
            return new Info(0, 0);
        }
        Info left_c = process(head.left);
        Info right_c = process(head.right);
        int m1 = left_c.maxDis;
        int m2 = right_c.maxDis;
        int m3 = left_c.height + 1 + right_c.height;
        int m = Math.max(m1, Math.max(m2, m3));
        int h = Math.max(left_c.height, right_c.height) + 1;
        return new Info(m, h);
    }

}
