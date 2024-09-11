package com.company.BNtree;


import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//LCR 043 完全二叉树插入器
class CBTInserter {
    private List<TreeNode> list = new ArrayList<>();
    private TreeNode root;

    public CBTInserter(TreeNode root) {
        if(root == null){
            return;
        }
        this.root = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            list.add(curNode);
            if(curNode.left != null){
                queue.add(curNode.left);
            }
            if(curNode.right != null){
                queue.add(curNode.right);
            }
        }
    }
    
    public int insert(int v) {
        TreeNode curNode = new TreeNode(v);
        list.add(curNode);
        int curIndex = list.size() - 1;
        int fatherIndex = (curIndex - 1) / 2;
        TreeNode fatherNode = list.get(fatherIndex);
        if((curIndex & 1) == 0){
            fatherNode.right = curNode;
        }else {
            fatherNode.left = curNode;
        }
        return fatherNode.val;
    }
    
    public TreeNode get_root() {
        return root;
    }


    public class TreeNode {
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
        int a = -1 / 2;
        System.out.println(a);

        int[][] gra = {{1,2}, {1,2,3}};
        System.out.println(a);
    }
}