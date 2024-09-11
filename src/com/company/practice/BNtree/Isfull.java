package com.company.practice.BNtree;

import com.company.Tanxin.Hanoi;

public class Isfull {
    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int v) {
            val = v;
        }
    }

    public static class Returnt {
        public int height;
        public int nums;

        public Returnt(int h, int n) {
            height = h;
            nums = n;
        }
    }

    public static boolean isfull(Node head) {
        Returnt re = process(head);
        return (1 << re.height) - 1 == re.nums;
    }

    public static Returnt process(Node head) {
        if (head == null) {
            return new Returnt(0, 0);
        }
        Returnt leftc = process(head.left);
        Returnt rightc = process(head.right);

        int height = Math.max(leftc.height, rightc.height) + 1;
        int nums = leftc.nums + rightc.nums + 1;
        return new Returnt(height, nums);
    }
}
