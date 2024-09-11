package com.company.BNtree;

import java.util.Stack;

public class IsSameTree {
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

    public static boolean isSameTree(TreeNode p, TreeNode q) {

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
}
