package com.company.practice.Graph_p;

import com.company.Graph.Edge;
import com.company.Graph.Graph;

import java.util.*;

public class Kruskal_p {

    public static class UnionFind{

        private HashMap<Node_p, Node_p> fatherMap;

        private HashMap<Node_p, Integer> sizeMap;

        public UnionFind(){
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
        }

        public void makeSets(Collection<Node_p> nodes){
            fatherMap.clear();
            sizeMap.clear();
            for(Node_p node : nodes){
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        private Node_p findFather(Node_p node){
            Stack<Node_p> stack = new Stack<>();
            while(node != fatherMap.get(node)){
                stack.add(node);
                node = fatherMap.get(node);
            }

            while(!stack.isEmpty()){
                fatherMap.put(stack.pop(),node);
            }
            return node;
        }

        public boolean isSameSet(Node_p a, Node_p b){
            return findFather(a) == findFather(b);
        }

        public void union(Node_p a, Node_p b){
            if(a == null || b == null){
                return;
            }

            Node_p aF = fatherMap.get(a);
            Node_p bF = fatherMap.get(b);

            if(aF == bF){
                return;
            }

            Integer aSize = sizeMap.get(aF);
            Integer bSize = sizeMap.get(bF);

            if(aSize < bSize){
                fatherMap.put(aF,bF);
                sizeMap.put(bF,aSize + bSize);
                sizeMap.remove(aF);
            }else {
                fatherMap.put(bF,aF);
                sizeMap.put(aF,aSize + bSize);
                sizeMap.remove(bF);
            }
        }
    }


    public static class EdgeComparator implements Comparator<Edge_p>{
        @Override
        public int compare(Edge_p o1, Edge_p o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge_p> krusksalMST(Graph_p graphP){
        UnionFind unionFind = new UnionFind();
        unionFind.makeSets(graphP.nodes.values());
        PriorityQueue<Edge_p> edgePriorityQueue = new PriorityQueue<>(new EdgeComparator());
        for(Edge_p edge : graphP.edges){
            edgePriorityQueue.add(edge);
        }

        Set<Edge_p> result = new HashSet<>();
        while(!edgePriorityQueue.isEmpty()){
            Edge_p edgeP = edgePriorityQueue.poll();
            if(!unionFind.isSameSet(edgeP.from, edgeP.to)){
                result.add(edgeP);
                unionFind.union(edgeP.from, edgeP.to);
            }
        }
        return result;
    }

}
