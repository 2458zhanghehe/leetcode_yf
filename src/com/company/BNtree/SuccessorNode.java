package com.company.BNtree;

import com.sun.xml.internal.ws.addressing.WsaTubeHelperImpl;

public class SuccessorNode {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int v) {
            value = v;
        }
    }

    //假设二叉树的父节点也给出。找二叉树节点X的后继节点（中序遍历X的下一个节点）
    //通过Arrays存储中序遍历可找出，但时间复杂度为O(N)
    //下面时间复杂度为O(k),k为二叉树中节点x到其后继节点的距离
    public static Node Successor(Node head) {
        if (head == null) {
            return null;
        }
        if (head.right != null) {
            return MostleftNode(head.right);
        } else {
            Node parent = head.parent;
            while (parent != null && parent.left != head) {
                head = parent;
                parent = head.parent;
            }
            return parent;
        }
    }

    public static Node MostleftNode(Node head) {
        while (head.left != null) {
            head = head.left;
        }
        return head;
    }

}
