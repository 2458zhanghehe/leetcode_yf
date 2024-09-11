package com.company.BNtree;

import java.util.Stack;

public class IncreasingBST {
    public static TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode ansHead = null;
        TreeNode curNode = null;
        while(root != null || !stack.isEmpty()){
            if(root != null){
                stack.add(root);
                root = root.left;
            }else {
                TreeNode cur = stack.pop();
                root = cur.right;
                cur.left = null;
                cur.right = null;
                if(ansHead == null){
                    ansHead = cur;
                    curNode = ansHead;
                }else {
                    curNode.right = cur;
                    curNode = curNode.right;
                }
            }
        }
        return ansHead;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);
        increasingBST(root);
    }
}
