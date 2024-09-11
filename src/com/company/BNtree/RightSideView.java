package com.company.BNtree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//leetcode199 二叉树的右视图
public class RightSideView {

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



    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode curEndNode = root;
        TreeNode nextEndNode = null;
        queue.add(root);

        List<Integer> ansList = new ArrayList<>();

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
                ansList.add(cur.val);
                curEndNode = nextEndNode;
                nextEndNode = null;
            }
        }
        return ansList;
    }
}
