package com.company.BNtree;

import java.util.*;

//leetcode 103 二叉树的锯齿形层序遍历 （所谓锯齿形即第一层从左往右，第二层从右往左，第三层从左往右。。。）
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode curLevelEndNode = root;
        TreeNode nextLevelEndNode = null;
        Stack<TreeNode> stack = new Stack<>();
        boolean flag = true;
        List<List<Integer>> ans = new ArrayList<>();
        queue.add(root);
        ArrayList<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            list.add(cur.val);
            if(flag){
                if(cur.left != null){
                    stack.add(cur.left);
                }
                if(cur.right != null){
                    stack.add(cur.right);
                }
            }else {
                if(cur.right != null){
                    stack.add(cur.right);
                }
                if(cur.left != null){
                    stack.add(cur.left);
                }
            }
            if(queue.isEmpty()){
                ans.add(list);
                list = new ArrayList<>();
                flag = !flag;
                while(!stack.isEmpty()){
                    queue.add(stack.pop());
                }
            }
        }
        return ans;
    }

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
}
