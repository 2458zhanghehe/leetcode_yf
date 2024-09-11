package com.company.BNtree;

import java.util.LinkedList;
import java.util.Queue;

// LCR048 二叉树的序列化和反序列化
public class SerializeAndReconstrcutTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    public static String serialByPre(Node head) {
        if (head == null) {
            return "#_";
        }
        String res = head.value + "_";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    public static Node reconByPre(String preStr) {
        String[] strs = preStr.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < strs.length; i++) {
            queue.add(strs[i]);
        }
        return process(queue);
    }

    public static Node process(Queue<String> queue) {
        String cur = queue.poll();
        if (cur.equals("#")) {
            return null;
        }
        Node head = new Node(Integer.valueOf(cur));
        head.left = process(queue);
        head.right = process(queue);
        return head;
    }

}
