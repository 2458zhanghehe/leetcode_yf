package com.company.Bishi.hema;

public class P1 {

    public Node lowestCommonA(Node head, Node o1, Node o2){
        if(head == null || head == o1 || head ==o2){
            return head;
        }

        Node left = lowestCommonA(head.left, o1, o2);
        Node right = lowestCommonA(head.right, o1, o2);
        if(left != null && right != null){
            return head;
        }
        return left != null ? left : right;
    }

    class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int v){
            value = v;
        }
    }
}
