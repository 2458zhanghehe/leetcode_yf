package com.company.BNtree;

import java.util.HashMap;

//leetcode106 从中序与后序遍历构造二叉树
public class InPos2Tree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //val index of inorder
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inMap.put(inorder[i],i);
        }
        TreeNode head = new TreeNode();
        process(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, head, inMap);
        return head;
    }

    private void process(int[] inorder, int[] postorder, int ini, int inj, int posi, int posj, TreeNode cur, HashMap<Integer,Integer> inMap) {
        if(ini > inj){
            return;
        }
        if(ini == inj){
            cur.val = inorder[ini];
            return;
        }
        cur.val = postorder[posj];

        int index = inMap.get(postorder[posj]);
        if(ini <= index - 1){
            cur.left = new TreeNode();
            process(inorder, postorder, ini,index - 1, posi,posi + index - ini - 1, cur.left, inMap);
        }
        if(index + 1 <= inj){
            cur.right = new TreeNode();
            process(inorder, postorder, index + 1, inj, posi + index - ini,posj - 1, cur.right, inMap);
        }
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
