package com.company.Graph;

import com.company.Shousi.WriteHashMap.MyMap;

import java.util.*;

public class SnakeAndLadders {
    private static Node[] nodes = new Node[401];

    public static int snakesAndLadders(int[][] board) {
        int n = 1;
        int len = board.length;
        build(len);

        boolean order = true;
        for(int i = len - 1; i >= 0; i--){
            if(order){
                for(int j = 0; j < len; j++){
                    n = process(board[i][j], n, len * len);
                }
                order = false;
            }else {
                for(int j = len - 1; j >= 0; j--){
                    n = process(board[i][j], n, len * len);
                }
                order = true;
            }
        }

        HashMap<Node, Integer> distanceMap = new HashMap<>();
        HashSet<Node> selectedSet = new HashSet<>();

        distanceMap.put(nodes[1], 0);
        Node minNode = getMinAndNotSelected(distanceMap, selectedSet);
        while(minNode != null){
            Integer minDis = distanceMap.get(minNode);
            for(Edge curEdge : minNode.edges){
                Node toNode = curEdge.to;
                Integer preDis = distanceMap.getOrDefault(toNode, Integer.MAX_VALUE);
                distanceMap.put(toNode, Math.min(preDis, minDis + curEdge.weight));
            }
            selectedSet.add(minNode);
            minNode = getMinAndNotSelected(distanceMap, selectedSet);
        }

        return distanceMap.get(nodes[len * len]);
    }

    private static Node getMinAndNotSelected(HashMap<Node, Integer> distanceMap, HashSet<Node> selectedSet) {
        Node minNode = null;
        int minDis = Integer.MAX_VALUE;
        for(Map.Entry<Node, Integer> entry : distanceMap.entrySet()){
            Node curNode = entry.getKey();
            Integer curDis = entry.getValue();
            if(curDis < minDis && !selectedSet.contains(curNode)){
                minDis = curDis;
                minNode = curNode;
            }
        }
        return minNode;
    }

    private static int process(int curBoard, int n, int limit) {
        Node curNode = nodes[n];
        for (int k = 1; k <= 6; k++) {
            if(n + k > limit){
                break;
            }
            Edge edge = null;
            if(n + k == curBoard){
                edge = new Edge(0, curNode, nodes[n + k]);
            }else {
                edge = new Edge(1, curNode, nodes[n + k]);
            }
            curNode.nexts.add(nodes[n + k]);
            curNode.edges.add(edge);
            curNode.out++;
            nodes[n + k].in++;
        }
        if(curBoard > n + 6){
            curNode.nexts.add(nodes[curBoard]);
            Edge edge = new Edge(0, curNode, nodes[curBoard]);
            curNode.edges.add(edge);
            curNode.out++;
            nodes[curBoard].in++;
        }
        n++;
        return n;
    }

    private static void build(int len) {
        for (int i = 1; i <= len * len; i++) {
            nodes[i] = new Node(i);
        }
    }

    static class Node{
        public int val;
        public int in;
        public int out;
        public List<Node> nexts;
        public List<Edge> edges;

        public Node(int val) {
            this.val = val;
            in = 0;
            out = 0;
            nexts = new ArrayList<>();
            edges = new ArrayList<>();
        }
    }

    static class Edge{
        public int weight;
        public Node from;
        public Node to;

        public Edge(int weight, Node from, Node to) {
            this.weight = weight;
            this.from = from;
            this.to = to;
        }
    }

    public static void main(String[] args) {
        int[][] board = {{-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,15,-1,-1,-1,-1}};
        snakesAndLadders(board);
    }
}
