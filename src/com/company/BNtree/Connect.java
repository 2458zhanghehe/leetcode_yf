package com.company.BNtree;

import java.util.LinkedList;
import java.util.Queue;

public class Connect {

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node curLevelEnd = root;
        Node nextLevelEnd = null;
        Node preNode = null;
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur.left != null){
                queue.add(cur.left);
                nextLevelEnd = cur.left;
            }
            if(cur.right != null){
                queue.add(cur.right);
                nextLevelEnd = cur.right;
            }
            if(preNode != null){
                preNode.next = cur;
            }
            preNode = cur;

            if(cur == curLevelEnd){
                cur.next = null;
                curLevelEnd = nextLevelEnd;
                preNode = null;
            }
        }
        return root;
    }

}
