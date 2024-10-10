package com.company.Bishi.Huawei.Day0925;

import java.util.*;

//社交网络用户影响力计算
public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int k = sc.nextInt();

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < n; i++) {
            int index1 = sc.nextInt();
            int index2 = sc.nextInt();
            nodes[index2].nexts.add(nodes[index1]);
            nodes[index1].nexts.add(nodes[index2]);
        }

        // “多”源bfs遍历
        ArrayList<Node> list = new ArrayList<>();
        list.add(nodes[target]);
        HashSet<Node> already = new HashSet<>();
        already.add(nodes[target]);
        int ans = 0;
        int l = 0;
        int r = 1;
        while(l < r && k > 0){
            for (int i = l; i < r; i++) {
                Node cur = list.get(i);
                for(Node next : cur.nexts){
                    if(!already.contains(next)){
                        ans++;
                        list.add(next);
                        already.add(next);
                    }
                }
            }
            l = r;
            r = list.size();
            k--;
        }
        System.out.println(ans);

//        HashSet<Integer> ans = new HashSet<>();
//        HashSet<Node> already = new HashSet<>();
//        already.add(nodes[target]);
//        process(target, nodes, k, already, ans);
//        System.out.println(ans.size());

    }

    private static void process(int index, Node[] nodes, int rest, HashSet<Node> already, HashSet<Integer> ans) {
        if(rest <= 0){
            return;
        }
        List<Node> nexts = nodes[index].nexts;
        for(Node next : nexts){
            if(!already.contains(next)){
                ans.add(next.val);
                already.add(next);
                process(next.val, nodes, rest - 1, already, ans);
                already.remove(next);
            }
        }
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
