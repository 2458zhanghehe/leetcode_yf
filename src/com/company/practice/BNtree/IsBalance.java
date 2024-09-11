package com.company.practice.BNtree;

public class IsBalance {
    public static class Node {
        public int val;
        public static Node left;
        public static Node right;

        public Node(int v) {
            val = v;
        }
    }

    public static boolean isbalance(Node head) {
        return process(head).isbalance;
    }


    public static Returntype process(Node head) {
        if (head == null) {
            return new Returntype(true, 0);
        }
        Returntype leftReturn = process(head.left);
        Returntype rightReturn = process(head.right);
        int height = Math.max(leftReturn.height, rightReturn.height) + 1;
        boolean isbalance = leftReturn.isbalance && rightReturn.isbalance
                && Math.abs(leftReturn.height - rightReturn.height) < 2;
        return new Returntype(isbalance, height);
    }

    public static class Returntype {
        public int height;
        public boolean isbalance;

        public Returntype(boolean is, int h) {
            isbalance = is;
            height = h;
        }
    }

}
