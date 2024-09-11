package com.company.practice.BNtree;

import java.util.LinkedList;
import java.util.Queue;

public class Iscbt {
    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int v) {
            val = v;
        }
    }

    public static boolean iscbt_p(Node head) {
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        boolean flag = false;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            Node leftc = cur.left;
            Node rightc = cur.right;
            if ((leftc == null && rightc != null) ||
                    flag && (leftc != null || rightc != null)) {
                return false;
            }
            if (leftc == null || rightc == null) {
                flag = true;
            }
            if (leftc != null) {
                queue.add(leftc);
            }
            if (rightc != null) {
                queue.add(rightc);
            }
        }
        return true;
    }

}
