package com.company.Graph;

import java.util.*;

//leetcode 207  有向图是否有环
public class IsLoop {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Node[] nodes = new Node[numCourses];
        for (int i = 0; i < numCourses; i++) {
            nodes[i] = new Node(i);
        }
        for(int[] cur : prerequisites){
            Node from = nodes[cur[1]];
            Node to = nodes[cur[0]];
            Edge edge = new Edge(from, to, 1);
            from.edges.add(edge);
            from.nexts.add(to);
            from.out++;
            to.in++;
        }

        //利用拓扑排序可以检验有向图是否有环    DFS可以检验有向/无向图是否有环
        Queue<Node> zeroInQueue = new LinkedList<>();
        for(Node node : nodes){
            if(node.in == 0){
                zeroInQueue.add(node);
            }
        }
        while(!zeroInQueue.isEmpty()){
            Node cur = zeroInQueue.poll();
            for(Node next : cur.nexts){
                next.in--;
                if(next.in == 0){
                    zeroInQueue.add(next);
                }
            }
            numCourses--;
        }

        return numCourses == 0;
    }

    class Node{
        public int val;
        public int in; //入度
        public int out;
        public List<Node> nexts;
        public List<Edge> edges;

        public Node(int val){
            this.val = val;
            in = 0;
            out = 0;
            nexts = new ArrayList<>();
            edges = new ArrayList<>();
        }
    }

    class Edge{
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
