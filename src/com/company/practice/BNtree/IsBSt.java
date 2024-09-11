package com.company.practice.BNtree;

import sun.security.krb5.internal.APRep;

import java.util.*;

public class IsBSt {
    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int v) {
            val = v;
        }
    }

    public static boolean IsBSTRecur1(Node head) {
        if (head == null) {
            return true;
        }
        List<Node> list = new ArrayList<>();
        process(list, head);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).val >= list.get(i + 1).val) {
                return false;
            }
        }
        return true;
    }

    public static void process(List<Node> list, Node head) {
        if (head == null) {
            return;
        }
        process(list, head.left);
        list.add(head);
        process(list, head.right);
    }

    public static boolean isBSTNoRecur(Node head) {
        if (head == null) {
            return true;
        }
        Stack<Node> stack = new Stack<>();
        int preval = Integer.MIN_VALUE;
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.add(head);
                head = head.left;
            } else {
                Node cur = stack.pop();
                if (cur.val <= preval) {
                    return false;
                } else {
                    preval = cur.val;
                }
                head = cur.right;
            }

        }
        return true;
    }

    public static int Preval = Integer.MIN_VALUE;

    public static boolean isBSTRecur2(Node head) {
        if (head == null) {
            return true;
        }
        boolean isleft = isBSTRecur2(head.left);
        if (!isleft) {
            return false;
        }
        if (head.val <= Preval) {
            return false;
        } else {
            Preval = head.val;
        }
        return isBSTRecur2(head.right);
    }


    public static boolean isBSTRecur3(Node head) {
        return process3(head).isbalance;
    }

    public static ReturnInfo process3(Node head) {
        if (head == null) {
            return null;
        }
        ReturnInfo leftc = process3(head.left);
        ReturnInfo rightc = process3(head.right);
        int max = head.val;
        int min = head.val;
        if (leftc != null) {
            max = Math.max(max, leftc.max);
            min = Math.min(min, leftc.min);
        }
        if (rightc != null) {
            max = Math.max(max, rightc.max);
            min = Math.min(min, leftc.min);
        }

        boolean isBST = true;
        if (leftc != null) {
            if (leftc.max >= head.val) {
                isBST = false;
            }

        }
        if (rightc != null) {
            if (rightc.min <= head.val) {
                isBST = false;
            }
        }
        isBST = isBST && leftc.isbalance && rightc.isbalance;
        return new ReturnInfo(isBST, min, max);
    }

    public static class ReturnInfo {
        public boolean isbalance;
        public int min;
        public int max;

        public ReturnInfo(boolean is, int min, int max) {
            isbalance = is;
            this.min = min;
            this.max = max;
        }
    }

}
