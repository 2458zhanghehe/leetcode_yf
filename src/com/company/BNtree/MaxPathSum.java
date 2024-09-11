package com.company.BNtree;

//leetcode 124 二叉树中的最大路径和
//树形dp不会
public class MaxPathSum {
    public int maxPathSum(TreeNode root) {
        return process(root).maxPath;
    }

    private Info process(TreeNode root) {
        if(root.left == null && root.right == null){
            return new Info(root.val, root.val);
        }

        int curMaxDepthPath;
        int curMaxPath;
        if(root.left == null){
            Info infoRight = process(root.right);
            curMaxDepthPath = infoRight.maxDepthPath <= 0 ? root.val : (infoRight.maxDepthPath + root.val);
            curMaxPath = Math.max(curMaxDepthPath, infoRight.maxPath);
        }else if(root.right == null){
            Info infoLeft = process(root.left);
            curMaxDepthPath = infoLeft.maxDepthPath <= 0 ? root.val : (infoLeft.maxDepthPath + root.val);
            curMaxPath = Math.max(curMaxDepthPath, infoLeft.maxPath);
        }else{
            Info infoLeft = process(root.left);
            Info infoRight = process(root.right);
            if(infoLeft.maxDepthPath <= 0 && infoRight.maxDepthPath <= 0){
                curMaxDepthPath = root.val;
                curMaxPath = Math.max(root.val,
                        Math.max(infoLeft.maxPath, infoRight.maxPath));
            }else if(infoLeft.maxDepthPath <= 0){
                curMaxDepthPath = root.val + infoRight.maxDepthPath;
                curMaxPath = Math.max(root.val + infoRight.maxDepthPath,
                        Math.max(infoLeft.maxPath, infoRight.maxPath));
            } else if(infoRight.maxDepthPath <= 0){
                curMaxDepthPath = root.val + infoLeft.maxDepthPath;
                curMaxPath = Math.max(root.val + infoLeft.maxDepthPath,
                        Math.max(infoLeft.maxPath, infoRight.maxPath));
            }else {
                curMaxDepthPath = Math.max(infoLeft.maxDepthPath, infoRight.maxDepthPath) + root.val;
                curMaxPath = Math.max(infoLeft.maxDepthPath + infoRight.maxDepthPath + root.val,
                        Math.max(infoLeft.maxPath, infoRight.maxPath));
            }
        }
        return new Info(curMaxPath, curMaxDepthPath);
    }


    class Info{
        public int maxPath;
        public int maxDepthPath;

        public Info(int maxPath, int maxDepthPath) {
            this.maxPath = maxPath;
            this.maxDepthPath = maxDepthPath;
        }
    }

    public static void main(String[] args) {
        MaxPathSum maxPathSum = new MaxPathSum();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(maxPathSum.maxPathSum(root));
    }
}

class  TreeNode {
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
