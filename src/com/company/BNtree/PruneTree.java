package com.company.BNtree;

//LCR 047 二叉树剪纸
public class PruneTree {

    public TreeNode pruneTree(TreeNode root) {
        boolean ans = process(root);
        return ans ? null : root;
    }

    private boolean process(TreeNode root) {
        if(root == null){
            return true;
        }

        boolean isLeft0 = process(root.left);
        if(isLeft0){
            root.left = null;
        }
        boolean isRight0 = process(root.right);
        if(isRight0){
            root.right = null;
        }
        if(isLeft0 && isRight0 && root.val == 0){
            return true;
        }else {
            return false;
        }
    }

    class TreeNode {
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

    }
}


