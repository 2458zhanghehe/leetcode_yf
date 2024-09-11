package com.company.BNtree;

import java.util.Stack;

//leetcode230
public class KthSmallest {
    public static class TreeNode {
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

    public int kthSmallest(TreeNode root, int k) {
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();

        while(!stack.isEmpty() || root != null){
            if(root != null){
                stack.add(root);
                root = root.left;
            }else {
                root = stack.pop();
                if(++count == k){
                    return root.val;
                }
                root = root.right;
            }
        }
        return -1;
    }
}
