package com.company.BNtree;

// 作业帮二面手撕  给两棵树如下：
//   2         1
// 3   4     5   7
//                 6
//对应节点合并，值相加，并且大于10需要进位
//   3                    4
// 8   11       --->    8   1
//        6                   6

public class PPP {
    private static TreeNode merge(TreeNode t1, TreeNode t2){
//        TreeNode ansT = new TreeNode(t1.val + t2.val);
//        Info info1 = process(t1.left, t2.left);
//        Info info2 = process(t1.right, t2.right);
//        ansT.left = info1.child;
//        ansT.right = info2.child;
//        ansT.val += info1.jin + info2.jin;
        Info ansInfo = process(t1, t2);
        ansInfo.child.val += ansInfo.jin;
        return ansInfo.child;
    }
    private static Info process(TreeNode cur1, TreeNode cur2) {
        if(cur1 == null && cur2 == null){
            return new Info(0, null);
        }
        Info info1 = process(cur1 == null ? null : cur1.left, cur2 == null ? null : cur2.left);
        Info info2 = process(cur1 == null ? null : cur1.right, cur2 == null ? null : cur2.right);
        int cur = info1.jin + info2.jin + (cur1 == null ? 0 : cur1.val) + (cur2 == null ? 0 : cur2.val);
        TreeNode curNode = new TreeNode(cur % 10);
        curNode.left = info1.child;
        curNode.right = info2.child;
        return new Info(cur / 10, curNode);
    }
    static class Info{
        public int jin;
        public TreeNode child;
        public Info(int jin, TreeNode child){
            this.jin = jin;
            this.child = child;
        }
    }
    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val){
            this.val = val;
            left = null;
            right = null;
        }
    }


    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(7);
        root2.right.right = new TreeNode(6);

        TreeNode root = merge(root1, root2);
        System.out.println(1);
    }
}
