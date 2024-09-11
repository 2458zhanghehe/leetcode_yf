package com.company.BNtree;

public class Lowest_commom_Ancestor {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    public static Node lowestAncestor(Node head, Node o1, Node o2) {
        if (head == null || head == o1 || head == o2) {
            return head;
        }
        Node left = lowestAncestor(head.left, o1, o2);
        Node right = lowestAncestor(head.right, o1, o2);

        if (left != null && right != null) {
            return head;
        }
        return left != null ? left : right;
    }


    public static void main(String[] args) {
        Node head = new Node(8);
        head.left = new Node(7);
        head.right = new Node(6);
        head.left.left = new Node(5);
        head.left.right = new Node(4);

        Node c = lowestAncestor(head, head.left.left, head.left.right);
        System.out.println(c.value);
    }
}
