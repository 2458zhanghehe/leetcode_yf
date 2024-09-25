package com.company.Bishi.Huawei.Day0717;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < n; i++) {
            int index1 = sc.nextInt();
            int index2 = sc.nextInt();
            nodes[index1].nexts.add(nodes[index2]);
        }

        int q = sc.nextInt();
        while(--q >= 0){
            int index1 = sc.nextInt();
            int index2 = sc.nextInt();
            boolean isDependency = process(nodes[index1], nodes[index2]);
            if(isDependency){
                System.out.println(1);
            }else {
                System.out.println(0);
            }
        }
    }

    private static boolean process(Node node1, Node node2) {
        if(node1 == node2){
            return true;
        }
        if(node1 == null){
            return false;
        }
        boolean ans = false;
        List<Node> nexts = node1.nexts;
        for(Node cur : nexts){
            ans |= process(cur, node2);
        }
        return ans;
    }

    static class Node{
        public int val;
        public List<Node> nexts;
        public Node(int val){
            this.val = val;
            nexts = new ArrayList<>();
        }
    }
}
