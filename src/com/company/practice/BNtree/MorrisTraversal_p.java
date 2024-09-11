package com.company.practice.BNtree;

public class MorrisTraversal_p {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    //Morris时间复杂度为O(N)，利用叶节点的空指针实现
    public static void Morris(Node head) {
        Node cur = head;
        Node mostRightOne = null;
        while (cur != null) {
            System.out.println(cur.value);
            mostRightOne = cur.left;
            if (mostRightOne != null) {
                while (mostRightOne.right != null && mostRightOne.right != cur) {
                    mostRightOne = mostRightOne.right;
                }
                if (mostRightOne.right == null) {
                    mostRightOne.right = cur;
                    cur = cur.left;
                    continue;
                }
                if (mostRightOne.right == cur) {
                    mostRightOne.right = null;
                }
            }
            cur = cur.right;
        }
    }

    public static void MorrisPre(Node head) {
        Node cur = head;
        Node mostRightOne = null;
        while (cur != null) {
            mostRightOne = cur.left;
            if (mostRightOne != null) {
                while (mostRightOne.right != null && mostRightOne.right != cur) {
                    mostRightOne = mostRightOne.right;
                }
                if (mostRightOne.right == null) {
                    mostRightOne.right = cur;
                    System.out.println(cur.value);
                    cur = cur.left;
                    continue;
                }
                if (mostRightOne.right == cur) {
                    mostRightOne.right = null;
                }
            } else {
                System.out.println(cur.value);
            }
            cur = cur.right;
        }
    }

    public static void MorrisIn(Node head) {
        Node cur = head;
        Node mostRightOne = null;
        while (cur != null) {
            mostRightOne = cur.left;
            if (mostRightOne != null) {
                while (mostRightOne.right != null && mostRightOne.right != cur) {
                    mostRightOne = mostRightOne.right;
                }
                if (mostRightOne.right == null) {
                    mostRightOne.right = cur;
                    cur = cur.left;
                    continue;
                }
                if (mostRightOne.right == cur) {
                    mostRightOne.right = null;
                }
            }
            System.out.println(cur.value);
            cur = cur.right;
        }
    }

    public static boolean IsBST(Node head) {
        Node cur = head;
        Node mostRightOne = null;
        int prevalue = Integer.MIN_VALUE;
        while (cur != null) {
            mostRightOne = cur.left;
            if (mostRightOne != null) {
                while (mostRightOne.right != null && mostRightOne.right != cur) {
                    mostRightOne = mostRightOne.right;
                }
                if (mostRightOne.right == null) {
                    mostRightOne.right = cur;
                    cur = cur.left;
                    continue;
                }
                if (mostRightOne.right == cur) {
                    mostRightOne.right = null;
                    System.out.println(cur.value);
                }
            }
            if (prevalue >= cur.value) {
                return false;
            }
            prevalue = cur.value;
            System.out.println(cur.value);
            cur = cur.right;
        }
        return true;
    }


    public static void MorrisPos(Node head) {
        Node cur = head;
        Node mostRightOne = null;
        while (cur != null) {
            mostRightOne = cur.left;
            if (mostRightOne != null) {
                while (mostRightOne.right != null && mostRightOne.right != cur) {
                    mostRightOne = mostRightOne.right;
                }
                if (mostRightOne.right == null) {
                    mostRightOne.right = cur;
                    cur = cur.left;
                    continue;
                }
                if (mostRightOne.right == cur) {
                    mostRightOne.right = null;
                    printRightEdge(cur.left);
                }
            }
            cur = cur.right;
        }
        printRightEdge(head);
    }

    public static void printRightEdge(Node head) {
        Node pre = null;
        Node next = null;
        Node cur = head;
        while (cur != null) {
            next = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }
        cur = pre;
        while (cur != null) {
            System.out.println(cur.value);
            cur = cur.right;
        }
        cur = pre;
        pre = null;
        next = null;
        while (cur != null) {
            next = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        //Morris(head);
        //MorrisPre(head);
        MorrisIn(head);
        //MorrisPos(head);
    }
}
