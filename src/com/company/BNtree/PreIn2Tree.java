package com.company.BNtree;

import java.util.Arrays;
import java.util.HashMap;

//leetcode105 根据二叉树的先序遍历和中序遍历构造二叉树
//和PreIn2Pos思想相同
//仅适用两个树节点没有重复值
public class PreIn2Tree {

    private static HashMap<Integer,Integer> inMap = new HashMap<>();

    public static class Node{
        public int val;
        public Node left;
        public Node right;
        public Node(){}
        public Node(int val){
            this.val = val;
        }
    }

    public static Node preIn2Tree(int[] pre, int[] in){
        Node head = new Node();
        //val index
        for(int i = 0; i < in.length; i++){
            inMap.put(in[i],i);
        }
        process(pre, in, 0, pre.length - 1, 0, in.length - 1, head);
        return head;
    }

    private static void process(int[] pre, int[] in, int prei, int prej, int ini, int inj, Node cur) {
        if(prei > prej){
            return;
        }
        if(prei == prej){
            cur.val = pre[prei];
            return;
        }

        cur.val = pre[prei];
        int find = inMap.get(pre[prei]);

        if(prei + 1 <= prei + find - ini){
            cur.left = new Node();
            process(pre, in, prei + 1, prei + find - ini, ini, find - 1, cur.left);
        }
        if(prei + find - ini + 1 <= prej){
            cur.right = new Node();
            process(pre, in, prei + find - ini + 1, prej, find + 1, inj, cur.right);
        }
    }

    public static void main(String[] args) {
//        int[] pre = {1,2,4,5,3,6,7};
//        int[] in = {4,2,5,1,6,3,7};
//        Node head = preIn2Tree(pre, in);

        int[] pre = {1,2};
        int[] in = {2,1};
        Node head = preIn2Tree(pre, in);
    }
}
