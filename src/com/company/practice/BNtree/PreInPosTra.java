package com.company.practice.BNtree;

import java.util.Stack;
import java.util.stream.StreamSupport;

public class PreInPosTra {
    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int v) {
            val = v;
        }
    }

    public static void PreRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val + ' ');
        PreRecur(head.left);
        PreRecur(head.right);
    }

    public static void InRecur(Node head) {
        if (head == null) {
            return;
        }
        InRecur(head.left);
        System.out.println(head.val + ' ');
        InRecur(head.right);
    }

    public static void PosRecur(Node head) {
        if (head == null) {
            return;
        }
        PosRecur(head.left);
        PosRecur(head.right);
        System.out.println(head.val + ' ');
    }

    public static void PreNoRecur(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.val + ' ');
            stack.push(cur.right);
            stack.push(cur.left);
        }
    }

    public static void PosNoRecur(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Stack<Node> help = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            help.push(cur);
            stack.push(cur.left);
            stack.push(cur.right);
        }
        while (!help.isEmpty()) {
            System.out.println(help.pop().val + ' ');
        }
    }

    public static void Inloop(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        ;
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                Node cur = stack.pop();
                System.out.println(cur.val + ' ');
                head = cur.right;
            }
        }
    }
}
