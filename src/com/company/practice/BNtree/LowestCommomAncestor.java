package com.company.practice.BNtree;

import java.util.HashMap;
import java.util.HashSet;

public class LowestCommomAncestor {
    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int v) {
            val = v;
        }

    }

    public static Node lca(Node head, Node o1, Node o2) {
        HashMap<Node, Node> fathermap = new HashMap<>();
        fathermap.put(head, head);
        process(fathermap, head);
        HashSet<Node> set = new HashSet<>();
        Node cur = o1;
        while (cur != fathermap.get(cur)) {
            set.add(cur);
            cur = fathermap.get(cur);
        }
        set.add(head);
        cur = o2;
        while (!set.contains(cur)) {
            cur = fathermap.get(cur);
        }
        return cur;
    }

    public static void process(HashMap<Node, Node> map, Node head) {
        if (head == null) {
            return;
        }
        map.put(head.left, head);
        map.put(head.right, head);
        process(map, head.left);
        process(map, head.right);
    }

    public static Node cla2(Node head, Node o1, Node o2) {
        if (head == null || head == o1 || head == o2) {
            return head;
        }
        Node leftc = cla2(head.left, o1, o2);
        Node rightc = cla2(head.right, o1, o2);
        if (leftc != null && rightc != null) {
            return head;
        }
        return leftc != null ? leftc : rightc;
    }

}
