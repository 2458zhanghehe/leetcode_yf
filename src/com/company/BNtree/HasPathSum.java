package com.company.BNtree;

import java.util.Stack;

//leetcode112
public class HasPathSum {
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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        return process(root,targetSum,0);
    }

    private boolean process(TreeNode root, int targetSum, int curSum) {
        if(root.left == null && root.right == null){
            return (curSum + root.val) == targetSum;
        }
        if(root.left == null){
            return process(root.right, targetSum, curSum + root.val);
        }else if(root.right == null){
            return process(root.left, targetSum, curSum + root.val);
        }else {
            boolean left = process(root.left, targetSum, curSum + root.val);
            boolean right = process(root.right, targetSum, curSum + root.val);
            return left | right;
        }
    }
}
