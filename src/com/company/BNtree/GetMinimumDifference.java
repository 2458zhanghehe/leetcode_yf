package com.company.BNtree;

import java.util.Stack;

public class GetMinimumDifference {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int getMinimumDifference(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();

        int preVal = Integer.MIN_VALUE/2;
        int ans = Integer.MAX_VALUE;

        while(!stack.isEmpty() || root != null){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                ans = Math.min(root.val - preVal, ans);
                preVal = root.val;;
                root = root.right;
            }
        }
        return ans;
    }
}

