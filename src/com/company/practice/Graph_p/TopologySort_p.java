package com.company.practice.Graph_p;

import java.util.*;

public class TopologySort_p {

    public static List<Node_p> topologySort(Graph_p graph){
        HashMap<Node_p, Integer> inMap = new HashMap<>();
        Queue<Node_p> zeroInQueue = new LinkedList<>();

        for(Node_p node : graph.nodes.values()){
            inMap.put(node, node.in);
            if(node.in == 0){
                zeroInQueue.add(node);
            }
        }

        List<Node_p> result = new ArrayList<>();
        while(!zeroInQueue.isEmpty()){
            Node_p cur = zeroInQueue.poll();
            result.add(cur);
            for(Node_p next : cur.nexts){
                inMap.put(next, inMap.get(next) - 1);
                if(inMap.get(next) == 0){
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }
}
