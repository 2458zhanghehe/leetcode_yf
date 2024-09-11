package com.company.BNtree;

import java.util.ArrayList;
import java.util.List;

//leetcode 113 路径总和Ⅱ
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<List<Integer>> ansList = new ArrayList<>();
        if(root == null){
            return ansList;
        }
        process(root, targetSum, 0, new ArrayList<>(), ansList);
        return ansList;
    }

    private void process(TreeNode root, int targetSum, int curSum, ArrayList<Integer> path, ArrayList<List<Integer>> ansList) {
        if(root.left == null && root.right == null){
            if(curSum + root.val == targetSum){
                path.add(root.val);
                ansList.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }

        path.add(root.val);
        if(root.left != null){
            process(root.left, targetSum, curSum + root.val, path, ansList);
        }
        if(root.right != null){
            process(root.right, targetSum, curSum + root.val, path, ansList);
        }
        path.remove(path.size() - 1);
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
}



