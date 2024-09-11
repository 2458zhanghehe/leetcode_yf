package com.company.Graph;

import com.company.Shousi.WriteHashMap.MyMap;

import java.util.*;

//leetcode 433 最小基因变化
public class MinMutation {
    private static Node[] nodes = new Node[11];
    public static int minMutation(String startGene, String endGene, String[] bank) {
        int index = build(startGene, endGene, bank);
        if(index == -1){
            return -1;
        }
        for (int i = 0; i < bank.length; i++) {
            for (int j = i + 1; j < bank.length + 1; j++) {
                boolean isValid = check(nodes[i].val,nodes[j].val);
                if(isValid){
                    Edge edge1 = new Edge(nodes[i], nodes[j], 1);
                    Edge edge2 = new Edge(nodes[j], nodes[i], 1);
                    nodes[i].nexts.add(nodes[j]);
                    nodes[i].edges.add(edge1);
                    nodes[j].nexts.add(nodes[i]);
                    nodes[j].edges.add(edge2);
                }
            }
        }

        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(nodes[0], 0);
        HashSet<Node> selectedSet = new HashSet<>();
        Node minNode = findMinDistanceAndNotSelected(distanceMap, selectedSet);
        while(minNode != null){
            int dis = distanceMap.get(minNode);
            for(Edge edge : minNode.edges){
                Node toNode = edge.to;
                int preDis = distanceMap.getOrDefault(toNode, Integer.MAX_VALUE);
                distanceMap.put(toNode, Math.min(preDis, dis + edge.weight));
            }
            selectedSet.add(minNode);
            minNode = findMinDistanceAndNotSelected(distanceMap, selectedSet);
        }

        return distanceMap.getOrDefault(nodes[index], -1);
    }

    private static Node findMinDistanceAndNotSelected(HashMap<Node, Integer> distanceMap, HashSet<Node> selectedSet) {
        Node minNode = null;
        int minDis = Integer.MAX_VALUE;
        for(Map.Entry<Node, Integer> entry : distanceMap.entrySet()){
            Node curNode = entry.getKey();
            Integer curDis = entry.getValue();
            if(minDis > curDis && !selectedSet.contains(curNode)){
                minDis = curDis;
                minNode = curNode;
            }
        }
        return minNode;
    }

    private static boolean check(String str1, String str2) {
        int cnt = 0;
        for (int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i)){
                cnt++;
            }
            if(cnt > 1){
                return false;
            }
        }
        return true;
    }

    private static int build(String startGene, String endGene,String[] bank) {
        nodes[0] = new Node(startGene);
        int index = -1;
        for (int i = 0; i < bank.length; i++) {
            nodes[i + 1] = new Node(bank[i]);
            if(bank[i].equals(endGene)){
                index = i + 1;
            }
        }
        return index;
    }

    static class Node{
        public String val;
        public int in;
        public int out;
        public List<Node> nexts;
        public List<Edge> edges;

        public Node(String val){
            this.val = val;
            nexts = new ArrayList<>();
            edges = new ArrayList<>();
            in = 0;
            out = 0;
        }
    }

    static class Edge{
        public Node from;
        public Node to;
        public int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        String[] bank = {"AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"};
        String startGene = "AACCTTGG";
        String endGene = "AATTCCGG";
        int ans = minMutation(startGene, endGene, bank);
        System.out.println(ans);
    }
}
