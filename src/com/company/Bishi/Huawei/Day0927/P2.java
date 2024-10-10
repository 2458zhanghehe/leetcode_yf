package com.company.Bishi.Huawei.Day0927;

import java.util.*;
import java.util.stream.Collectors;

//最好的通勤体验
public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int home = sc.nextInt();
        int food = sc.nextInt();
        int company = sc.nextInt();
        int n = sc.nextInt();
        HashMap<Integer, Node> nodesMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int curSum = sc.nextInt();
            int[] nums = new int[curSum];
            for (int j = 0; j < curSum; j++) {
                nums[j] = sc.nextInt();
            }
            for (int j = 0; j < curSum - 1; j++) {
                int from = nums[j];
                int to = nums[j + 1];
                Node fromNode = nodesMap.getOrDefault(from, new Node(from));
                Node toNode = nodesMap.getOrDefault(to, new Node(to));
                Edge edge = new Edge(fromNode, toNode, i);
                fromNode.nexts.add(toNode);
                fromNode.edges.add(edge);
                nodesMap.put(from, fromNode);
                nodesMap.put(to,toNode);
            }
            Node fromNode = nodesMap.get(nums[curSum - 1]);
            Node toNode = nodesMap.get(nums[0]);
            Edge edge = new Edge(fromNode, toNode, i);
            fromNode.edges.add(edge);
            fromNode.nexts.add(toNode);
        }

        ArrayList<Integer> ansList1 = new ArrayList<>();
        process(home, food, nodesMap, new ArrayList<>(), ansList1, new HashSet<>());

        ArrayList<Integer> ansList2 = new ArrayList<>();
        process(food, company, nodesMap, new ArrayList<>(), ansList2, new HashSet<>());

        int ans = ansList1.size() + ansList2.size();
        if(ansList1.get(ansList1.size() - 1).equals(ansList2.get(0))){
            ans--;
        }
        System.out.println(ans);
    }

    private static void process(int start, int end, HashMap<Integer, Node> nodesMap, List<Integer> path, List<Integer> ans, Set<Integer> alreadyIndex) {
        if(start == end){
            path = path.stream().distinct().collect(Collectors.toList());
            if(ans.isEmpty()){
                ans.addAll(path);
            }
            if(ans.size() > path.size()){
                ans.clear();
                ans.addAll(path);
            }
            return;
        }
        if(alreadyIndex.contains(start)){
            return;
        }
        alreadyIndex.add(start);
        Node startNode = nodesMap.get(start);
        for(Edge edge : startNode.edges){
            path.add(edge.num);
            process(edge.to.val, end, nodesMap, path, ans, alreadyIndex);
            path.remove(path.size() - 1);
        }
    }

    static class Node{
        public int val;
        public List<Node> nexts;
        public List<Edge> edges;
        public Node(int val){
            this.val = val;
            nexts = new ArrayList<>();
            edges = new ArrayList<>();
        }
    }

    static class Edge{
        public Node from;
        public Node to;
        public int num;
        public Edge(Node from, Node to, int num) {
            this.from = from;
            this.to = to;
            this.num = num;
        }
    }
}
