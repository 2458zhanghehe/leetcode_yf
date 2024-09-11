package com.company.practice.BNtree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TreeMaxW {
    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int v) {
            val = v;
        }
    }

    public static void BFS(Node head) {   //二叉树宽度优先遍历BFS  二叉树深度优先遍历DFS即为二叉树的先序遍历
        if (head == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.val);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    public static int TreeMaxWHashMap(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Integer> map = new HashMap<>();
        queue.add(head);
        map.put(head, 1);
        int curlevels = 1;
        int curlevelNodes = 0;
        int ans = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (map.get(cur) == curlevels) {
                curlevelNodes++;
            } else {
                ans = Math.max(ans, curlevelNodes);
                curlevels++;
                curlevelNodes = 1;
            }
            if (cur.left != null) {
                queue.add(cur.left);
                map.put(cur.left, curlevels + 1);
            }
            if (cur.right != null) {
                queue.add(cur.right);
                map.put(cur.right, curlevels + 1);
            }
        }
        return Math.max(ans, curlevelNodes);
    }

    public static int TreeMaxWNoHash(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        Node curlevelendNode = head;
        Node nextlevelendNode = null;
        int ans = 0;
        int curlevelNodes = 0;
        queue.add(head);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
                nextlevelendNode = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextlevelendNode = cur.right;
            }
            if (cur == curlevelendNode) {
                ans = Math.max(ans, ++curlevelNodes);
                curlevelendNode = nextlevelendNode;
                nextlevelendNode = null;
            }
        }
        return ans;
    }

}
