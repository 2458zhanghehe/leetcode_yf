package com.company.Bishi.qiniu;

public class P2 {
    public int lowestCommonAncestor (TreeNode root, int m, int n) {
        TreeNode ansNode = process(root, new TreeNode(m), new TreeNode(n));
        return ansNode.val;
    }

    public TreeNode process(TreeNode root, TreeNode m, TreeNode n){
        if(root == null || root.val == m.val || root.val == n.val){
            return root;
        }
        TreeNode left = process(root.left, m, n);
        TreeNode right = process(root.right,m,n);
        if(left != null && right != null){
            return root;
        }
        return left != null ? left : right;
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
