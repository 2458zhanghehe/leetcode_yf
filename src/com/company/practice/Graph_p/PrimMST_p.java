package com.company.practice.Graph_p;



import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class PrimMST_p {

    public static class EdgeComparator implements Comparator<Edge_p>{
        @Override
        public int compare(Edge_p o1, Edge_p o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge_p> primMST(Graph_p graph){

        HashSet<Node_p> set = new HashSet<>();
        PriorityQueue<Edge_p> queue = new PriorityQueue<>(new EdgeComparator());
        Set<Edge_p> result = new HashSet<>();

        for(Node_p node : graph.nodes.values()){
            if(!set.contains(node)){
                set.add(node);
                queue.addAll(node.edges);
            }
            while(!queue.isEmpty()){
                Edge_p edgeP = queue.poll();
                Node_p toNode = edgeP.to;
                if(!set.contains(toNode)){
                    set.add(toNode);
                    result.add(edgeP);
                    queue.addAll(toNode.edges);
                }
            }
        }
        return result;
    }

}
