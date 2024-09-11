package com.company.BNtree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {
    public static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
    }

    public List<Double> averageOfLevels(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode curLevelEnd = root;
        TreeNode nextLevelEnd = null;
        Long curSum = 0L;
        int curNums = 0;
        queue.add(root);

        List<Double> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            curSum += cur.val;
            curNums++;
            if(cur.left != null){
                queue.add(cur.left);
                nextLevelEnd = cur.left;
            }

            if(cur.right != null){
                queue.add(cur.right);
                nextLevelEnd = cur.right;
            }

            if(cur == curLevelEnd){
                ans.add(curSum * 1.0 / curNums);
                curNums = 0;
                curSum =0L;
                curLevelEnd = nextLevelEnd;
            }
        }
        return ans;
    }
}
