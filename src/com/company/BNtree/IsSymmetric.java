package com.company.BNtree;

import java.util.Stack;

//leetcode 101
public class IsSymmetric {
    public class TreeNode {
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

    //先翻转左子树，再比较与右子树是否相等
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        TreeNode invertNode = invertTree(root.left);
        return isSameTree(invertNode,root.right);
    }

    public TreeNode invertTree(TreeNode root) {
        process(root);
        return root;
    }

    private void process(TreeNode root){
        if(root == null){
            return;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        process(root.left);
        process(root.right);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null){
            return true;
        }

        if(p == null || q == null || (p.val != q.val)){
            return false;
        }


        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();
        stackP.add(p);
        stackQ.add(q);

        while(!stackP.isEmpty()){
            TreeNode pNode = stackP.pop();
            TreeNode qNode = stackQ.pop();
            if(pNode.val != qNode.val){
                return false;
            }
            if(pNode.right != null && qNode.right != null){
                stackP.add(pNode.right);
                stackQ.add(qNode.right);
            }else if(pNode.right != null || qNode.right != null){
                return false;
            }

            if(pNode.left != null && qNode.left != null){
                stackP.add(pNode.left);
                stackQ.add(qNode.left);
            }else if(pNode.left != null || qNode.left != null){
                return false;
            }
        }
        return true;
    }


    public boolean isSymmetric2(TreeNode root) {
        if(root == null){
            return true;
        }

        return process2(root.left,root.right);
    }

    private boolean process2(TreeNode left, TreeNode right) {
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null || left.val != right.val){
            return false;
        }
        return process2(left.left, right.right) && process2(left.right, right.left);
    }
}
