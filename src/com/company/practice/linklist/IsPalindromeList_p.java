package com.company.practice.linklist;

import java.util.Stack;

public class IsPalindromeList_p {

    public static class Node {
        public int val;
        public Node next;

        public Node(int v) {
            val = v;
        }
    }

    public static boolean isPalindromeList_p1(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.add(cur);
            cur = cur.next;
        }
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (cur.val != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindromeList_p2(Node head) {
        if (head == null && head.next == null) {
            return true;
        }
        Node s = head;
        Node f = head;
        while (f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }
        s = s.next;
        Stack<Node> stack = new Stack<>();
        while (s != null) {
            stack.add(s);
            s = s.next;
        }

        while (!stack.isEmpty()) {
            f = stack.pop();
            if (f.val != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindromeList_p3(Node head) {
        Node f = head;
        Node s = head;
        while (f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }
        Node tail = reverse(s);
        Node right = tail;
        while (head != null && right != null) {
            if (head.val != right.val) {
                reverse(tail);
                return false;
            }
            head = head.next;
            right = right.next;
        }
        reverse(tail);
        return true;
    }

    public static Node reverse(Node head) {
        Node pre = null;
        Node cur = head;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
