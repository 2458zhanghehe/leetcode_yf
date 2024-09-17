package com.company.Bishi.redbook;

import java.util.*;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        Node[] nodes = new Node[n + 1];
        for (int i = 0; i < n - 1; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            if(nodes[num1] == null){
                nodes[num1] = new Node(num1);
            }
            if(nodes[num2] == null){
                nodes[num2] = new Node(num2);
            }
            int weight = sc.nextInt();
            Edge edge1 = new Edge(nodes[num1], nodes[num2], weight);
            Edge edge2 = new Edge(nodes[num2], nodes[num1], weight);
            nodes[num1].edges.add(edge1);
            nodes[num2].edges.add(edge2);
            nodes[num1].nexts.add(nodes[num2]);
            nodes[num2].nexts.add(nodes[num1]);
        }

        while(--q >= 0){
            int targetNum = sc.nextInt();
            int k = sc.nextInt();
            //weigh, num
            HashMap<Integer, Integer> map = new HashMap<>();
            HashSet<Node> set = new HashSet<>();
            map.put(0, 1);
            set.add(nodes[targetNum]);
            process(nodes[targetNum], 0, map, set);
            System.out.println(map.get(k));
        }

    }

    private static void process(Node node, int weight, HashMap<Integer, Integer> map, HashSet<Node> set) {
        for (Edge edge : node.edges) {
            if(set.contains(edge.to)){
                continue;
            }
            set.add(edge.to);
            int newWeight = weight ^ edge.weight;
            map.put(newWeight, map.getOrDefault(newWeight, 0) + 1);
            process(edge.to, newWeight, map, set);
        }
    }

    static class Node{
        public List<Node> nexts;
        public List<Edge> edges;
        public int num;

        public Node(int num) {
            this.num = num;
            nexts = new ArrayList<>();
            edges = new ArrayList<>();
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
}
