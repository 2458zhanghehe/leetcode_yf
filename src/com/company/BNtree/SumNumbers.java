package com.company.BNtree;


import java.util.ArrayList;

//leetcode129
public class SumNumbers {
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

    public int sumNumbers(TreeNode root) {
        return process(root,0);
    }

    private Integer process(TreeNode root, Integer sum) {
        if(root == null){
            return 0;
        }
        sum = sum * 10 + root.val;

        if(root.left == null && root.right == null){
            return sum;
        }
        return process(root.left,sum) + process(root.right,sum);
    }
}
