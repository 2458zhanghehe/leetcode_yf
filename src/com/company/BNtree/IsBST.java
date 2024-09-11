package com.company.BNtree;

import com.sun.org.apache.xpath.internal.operations.Bool;
import sun.applet.AppletResourceLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//判断是否为搜索二叉树
public class IsBST {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    public static int preval = Integer.MIN_VALUE;

    public static boolean isBSTRecur(Node head) {
        if (head == null) {
            return true;
        }
        Boolean isLeftBST = isBSTRecur(head.left);
        if (!isLeftBST) {
            return false;
        }
        if (head.value <= preval) {
            return false;
        } else {
            preval = head.value;
        }
        return isBSTRecur(head.right);
    }

    public static boolean isBSTRecur2(Node head) {
        if (head == null) {
            return true;
        }
        List<Node> list = new ArrayList<>();  //数组必须给定长度，所以不能使用Node[]，List可以动态扩容，长度无法给出时用List
        process2(list, head);

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).value >= list.get(i + 1).value) {
                return false;
            }
        }
        return true;
    }

    public static void process2(List<Node> list, Node head) {
        if (head == null) {
            return;
        }
        process2(list, head.left);
        list.add(head);
        process2(list, head.right);
    }

    public static boolean isBSTNoRecur(Node head) {   //注意 boolean为基本数据类型 而Boolean则为类
        if (head == null) {
            return true;
        }
        int preValue = Integer.MIN_VALUE;
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.add(head);
                head = head.left;
            } else {
                Node cur = stack.pop();
                if (cur.value <= preValue) {
                    return false;
                } else {
                    preValue = cur.value;
                }
                head = cur.right;
            }

        }
        return true;
    }


    public static class ReturnType {
        public boolean isbst;
        public int min;
        public int max;

        public ReturnType(boolean isbst, int min, int max) {
            this.isbst = isbst;
            this.max = max;
            this.min = min;
        }
    }

    public static ReturnType process(Node x) {
        if (x == null) {
            return null;
        }
        ReturnType leftReturn = process(x.left);
        ReturnType rightReturn = process(x.right);

        int min = x.value;
        int max = x.value;

        if (leftReturn != null) {
            min = Math.min(min, leftReturn.min);
            max = Math.max(max, leftReturn.max);
        }
        if (rightReturn != null) {
            min = Math.min(min, rightReturn.min);
            max = Math.max(max, rightReturn.max);
        }
        boolean isBST = true;
        if ((leftReturn != null) && (!leftReturn.isbst || leftReturn.max >= x.value)) {
            isBST = false;
        }
        if ((rightReturn != null) && (!rightReturn.isbst || rightReturn.min <= x.value)) {
            isBST = false;
        }
        return new ReturnType(isBST, min, max);
    }

    public static void main(String[] args) {

    }


}
