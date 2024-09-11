package com.company.BNtree;

import cn.hutool.core.lang.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

// leetcode 104 二叉树的最大深度
public class MaxDepth {
    //dfs
    public int maxDepth1(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth1(root.left);
        int right = maxDepth1(root.right);
        return Math.max(left, right) + 1;
    }

    // bfs
    public int maxDepth2(TreeNode root) {
        if(root == null){
            return 0;
        }
        int maxLevels = 0;
        TreeNode curEndNode = root;
        TreeNode nextEndNode = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur.left != null){
                queue.add(cur.left);
                nextEndNode = cur.left;
            }
            if(cur.right != null){
                queue.add(cur.right);
                nextEndNode = cur.right;
            }
            if(cur == curEndNode){
                curEndNode = nextEndNode;
                nextEndNode = null;
                maxLevels++;
            }
        }
        return maxLevels;
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
