package com.company.BNtree;

import java.util.LinkedList;
import java.util.Queue;

public class isCBT {
    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int v) {
            val = v;
        }
    }

    public static boolean iscbt(Node head) {
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        Node leftc = null;
        Node rightc = null;
        boolean flag = false;
        queue.add(head);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            leftc = cur.left;
            rightc = cur.right;
            if ((flag && (leftc != null || rightc != null))
                    || (leftc == null && rightc != null)) {
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
