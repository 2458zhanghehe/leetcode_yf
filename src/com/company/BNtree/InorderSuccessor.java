package com.company.BNtree;

import java.util.HashMap;

//LCR 053 二叉搜索树中的中序后继
public class InorderSuccessor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        //1. p有右子树
        if(p.right != null){
            TreeNode cur = p.right;
            while(cur.left != null){
                cur = cur.left;
            }
            return cur;
        }

        //2. p没有右子树，找祖先节点
        // child parent
        HashMap<TreeNode, TreeNode> fatherMap = new HashMap<>();
        TreeNode parent = null;
        while(root != p){
            //2.1 如果p没有右子树且p是父节点的左子树，直接返回父节点
            if(root.left == p){
                return root;
            }

            parent = root;
            root = root.val < p.val ? root.right : root.left;
            fatherMap.put(root, parent);
        }
        //2.2 p没有右子树且p是右孩子，找祖先是左孩子的节点的父
        while(parent != null && parent.left != p){
            p = parent;
            parent = fatherMap.get(p);
        }
        return parent;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
