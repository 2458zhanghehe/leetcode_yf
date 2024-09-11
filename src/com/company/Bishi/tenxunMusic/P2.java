package com.company.Bishi.tenxunMusic;

import java.util.LinkedList;
import java.util.Queue;

public class P2 {

    public static TreeNode makeCompleteTree(TreeNode root){
        if(root == null){
            return null;
        }
        int depth = 0;
        //二叉树的最大深度
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
            }
            depth++;
        }

        int depth2 = 0;
        queue.add(root);
        TreeNode nextEnd = null;
        while(!queue.isEmpty()){
            int size = queue.size();
            if(depth2 + 2 < depth){
                for(int i = 0; i < size; i++){
                    TreeNode cur = queue.poll();
                    if(cur.left == null){
                        cur.left = new TreeNode(1);
                    }
                    if(cur.right == null){
                        cur.right = new TreeNode(1);
                    }
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
            }else {
                Queue<TreeNode> copy = new LinkedList<>(queue);
                for(int i = 0; i < size; i++){
                    TreeNode cur = queue.poll();
                    if(cur.left != null){
                        queue.add(cur.left);
                        nextEnd = cur.left;
                    }
                    if(cur.right != null){
                        queue.add(cur.right);
                        nextEnd = cur.right;
                    }
                }

                for(int i = 0; i < size; i++){
                    TreeNode cur = copy.poll();
                    if(cur.left == null){
                        cur.left = new TreeNode(1);
                    }else if(cur.left == nextEnd){
                        break;
                    }

                    if(cur.right == null){
                        cur.right = new TreeNode(1);
                    }else if(cur.right == nextEnd){
                        break;
                    }
                }
            }
            depth2++;
        }
        return root;
    }

    static class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        makeCompleteTree(root);
    }
}



