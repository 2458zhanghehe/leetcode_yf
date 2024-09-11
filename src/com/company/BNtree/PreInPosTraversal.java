package com.company.BNtree;

import javafx.geometry.Pos;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PreInPosTraversal {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    //=================递归实现=================================================
    //先序遍历 (头左右)  每个子树都满足这个顺序
    public static void preOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + ".");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }


    //  中序遍历打印,左头右
    public static void inOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + ".");
        inOrderRecur(head.right);
    }

    //后序遍历 ，左右头
    public static void postOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        postOrderRecur(head.left);
        postOrderRecur(head.right);
        System.out.print(head.value + ".");
    }


    //=================非递归实现====================================
    //先序遍历（头左右） 二叉树的先序遍历即为二叉树的深度优先遍历
    public static void preOrderUnRecur(Node head) {
        System.out.print("pre_Order: ");
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.print(head.value + " ");
            if (head.right != null) {
                stack.add(head.right);
            }
            if (head.left != null) {
                stack.add(head.left);
            }
        }
    }

    //中序遍历(左头右)
    public static void inOrderUnRecur(Node head) {
        System.out.print("in_order: ");
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.value + " ");
                head = head.right;
            }

        }
    }

    //后序遍历(左右头)
    public static void PostOrderUnRecur1(Node head) {
        System.out.print("post_OrderFirst: ");
        if (head == null) {
            return;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(head);
        while (!stack1.isEmpty()) {
            head = stack1.pop();
            stack2.push(head);
            if (head.left != null) {
                stack1.push(head.left);
            }
            if (head.right != null) {
                stack1.push(head.right);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().value + " ");
        }
    }

    public static void posOrderUnRecur2(Node head) {
        System.out.print("pos-orderSecond: ");
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.push(head);
            Node stackTopNode = null;
            while (!stack.isEmpty()) {
                // stackTopNode 表示栈顶结点
                stackTopNode = stack.peek();
                // 如果栈顶结点的左右结点和最近打印的结点都不相等：说明栈顶结点的左右孩子都不是最近打印的结点，同样由于左右孩子分别为左右子树的头结点，
                // 根据后序遍历的特点（左右中），则左右子树都没有被打印过，所以压入左子树。
                if (stackTopNode.left != null && head != stackTopNode.left && head != stackTopNode.right) {
                    stack.push(stackTopNode.left);
                    // 如果上面没有执行：左子树不存在或者左子树刚刚打印过或者右子树刚刚打印过，如果是前两种情况，就接着打印右子树
                } else if (stackTopNode.right != null && head != stackTopNode.right) {
                    stack.push(stackTopNode.right);
                    // 上面还没有执行说明左右子树都空或者都打印完了，弹出该结点打印，然后更新。
                } else {
                    System.out.print(stack.pop().value + " ");
                    head = stackTopNode;
                }
            }
        }
        System.out.println();
    }

    //二叉树的宽度优先遍历
    public static void BN_w(Node head) {
        if (head == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();   //Queue是一个接口，LinkedList是实现Queue的一个类 队列用Queue声明
        queue.add(head);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        System.out.println("================递归方案=========");
        preOrderRecur(head);
        System.out.println();
        inOrderRecur(head);
        System.out.println();
        postOrderRecur(head);
        System.out.println();

        System.out.println("==============非递归方案=========");
        preOrderUnRecur(head);
        System.out.println();
        inOrderUnRecur(head);
        System.out.println();
        PostOrderUnRecur1(head);
        System.out.println();
        posOrderUnRecur2(head);

    }


}





