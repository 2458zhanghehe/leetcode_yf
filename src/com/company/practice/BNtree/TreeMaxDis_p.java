package com.company.practice.BNtree;

import java.util.Map;

// leetcode 543 树形dp，递归套路
public class TreeMaxDis_p {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    public static int TMD(Node head) {
        return process(head).maxDis;
    }

    public static class Info {
        public int maxDis;
        public int height;

        public Info(int maxDis, int height) {
            this.maxDis = maxDis;
            this.height = height;
        }
    }

    public static Info process(Node head) {
        if (head == null) {
            return new Info(0, 0);
        }
        Info leftCInfo = process(head.left);
        Info rightCInfo = process(head.right);
        int d1 = leftCInfo.maxDis;
        int d2 = rightCInfo.maxDis;
        int d3 = leftCInfo.height + 1 + rightCInfo.height;
        int m = Math.max(d1, Math.max(d2, d3));
        int h = Math.max(leftCInfo.height, rightCInfo.height) + 1;
        return new Info(m, h);
    }

}
