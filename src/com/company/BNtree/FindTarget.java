package com.company.BNtree;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

//LCR 056 二叉树的两数之和
public class FindTarget {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        HashSet<Integer> set = new HashSet<>();
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(set.contains(cur.val)){
                return true;
            }
            //加入差值，这样就可以边遍历边寻找
            set.add(k - cur.val);
            if(cur.right != null){
                stack.add(cur.right);
            }
            if(cur.left != null){
                stack.add(cur.left);
            }
        }
        return false;
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
}
