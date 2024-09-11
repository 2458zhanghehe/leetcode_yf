package com.company.BNtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//leetcode173
class BSTIterator {
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

    private List<Integer> list = null;
    private int next = -1;

    public BSTIterator(TreeNode root) {
        if(root == null){
            return;
        }
        list = new ArrayList<>();
        next = -1;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
    }
    
    public int next() {
        return list.get(++next);
    }
    
    public boolean hasNext() {
        if(next + 1 >= list.size()){
            return false;
        }
        return true;
    }
}