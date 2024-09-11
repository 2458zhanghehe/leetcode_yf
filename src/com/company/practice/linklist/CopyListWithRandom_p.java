package com.company.practice.linklist;

import java.util.HashMap;

public class CopyListWithRandom_p {

    public static class Node {
        public int value;
        public Node next;
        public Node random;

        public Node(int v) {
            value = v;
        }
    }

    public static Node copyListWithRandom1_p(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static Node copyListWithRandom2_p(Node head) {
        Node cur = head;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        while (cur != null) {
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        cur = head;
        Node ans = head.next;
        while (cur.next != null) {
            next = cur.next;
            cur.next = cur.next.next;
            cur = next;
        }
        return ans;
    }

}
