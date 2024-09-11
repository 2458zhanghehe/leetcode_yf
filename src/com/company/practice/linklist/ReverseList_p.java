package com.company.practice.linklist;

public class ReverseList_p {
    public static class Node {
        public int val;
        public Node next;

        public Node(int v) {
            val = v;
        }
    }

    public static Node reverseList_p(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
