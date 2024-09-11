package com.company.BNtree;

import java.util.HashMap;

//leetcode 437 路径总和Ⅲ
//要算元素A到元素B间的所有元素和，就用前缀和优化，不管是数组、链表还是树  重要
public class PathSum3 {
    public static int pathSum1(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        int ans1 = process(root.left, targetSum - root.val, true);
        int ans2 = process(root.right, targetSum - root.val, true);
        int ans3 = process(root.left, targetSum, false);
        int ans4 = process(root.right, targetSum, false);
        int ans = ans1 + ans2 + ans3 + ans4;
        return targetSum == root.val ? ans + 1 : ans;
    }

    private static int process(TreeNode root, long res, boolean has) {

        if(root == null){
            return 0;
        }

        if(has){
            int curAns = process(root.left, res - root.val, true) + process(root.right, res - root.val, true);
            return res == root.val ? curAns + 1 : curAns;
        }else {
            int curAns1 = process(root.left, res - root.val, true);
            int curAns2 = process(root.right, res - root.val, true);
            int curAns3 = process(root.left, res, false);
            int curAns4 = process(root.right, res, false);
            int curAns = curAns1 + curAns2 + curAns3 + curAns4;
            return res == root.val ? curAns + 1 : curAns;
        }
    }

    //前缀和优化解法
    //以key为前缀和的有多少个 在当前节点及其祖先的路径上
    private static HashMap<Long, Integer> prefixMap = new HashMap<>();
    public static int pathSum2(TreeNode root, int targetSum) {
        prefixMap.put(0L,1);
        return process1(root, 0, targetSum);
    }

    private static int process1(TreeNode curNode, long prefix, int targetSum){
        if(curNode == null){
            return 0;
        }
        long curPrefix = prefix + curNode.val;
        int res = prefixMap.getOrDefault(curPrefix - targetSum, 0);
        prefixMap.put(curPrefix, prefixMap.getOrDefault(curPrefix, 0) + 1);
        int left = process1(curNode.left, curPrefix, targetSum);
        int right = process1(curNode.right, curPrefix, targetSum);
        //子节点用完后删除该点的前缀，因为兄弟树的侄子节点到不了这里
        prefixMap.put(curPrefix,prefixMap.get(curPrefix) - 1);
        return res + left + right;
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

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(10);
//        root.left = new TreeNode(5);
//        root.right = new TreeNode(-3);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(2);
//        root.right.right = new TreeNode(11);
//        root.left.left.left = new TreeNode(3);
//        root.left.left.right = new TreeNode(-2);
//        root.left.right.right = new TreeNode(1);

        TreeNode root1 = new TreeNode(1);
        int ans1 = pathSum1(root1, 1);
        int ans2 = pathSum2(root1, 1);
        System.out.println(ans1 == ans2);

    }
}
