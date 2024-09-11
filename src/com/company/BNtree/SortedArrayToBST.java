package com.company.BNtree;

public class SortedArrayToBST {
    public static TreeNode sortedArrayToBST(int[] nums) {

        TreeNode head = new TreeNode();
        process(nums,0,nums.length - 1,head);
        return head;
    }

    private static void process(int[] nums, int l, int r, TreeNode head) {
        if(l == r){
            head.val = nums[l];
            return;
        }

        int mid = ((r + 1 - l) >> 1) + l;
        head.val = nums[mid];
        if(mid - 1 >= l){
            head.left = new TreeNode();
            process(nums,l,mid - 1,head.left);
        }
        if(r >= mid + 1){
            head.right = new TreeNode();
            process(nums,mid + 1, r, head.right);
        }
    }


    static class TreeNode {
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
        int[] nums = {-10,-3,0,5,9};
        sortedArrayToBST(nums);
    }
}
