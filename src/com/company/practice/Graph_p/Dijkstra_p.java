package com.company.practice.Graph_p;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Dijkstra_p {

    public static HashMap<Node_p, Integer> dijkstra(Node_p head){
        //点head到点key的距离
        HashMap<Node_p, Integer> distanceMap = new HashMap<>();

        HashSet<Node_p> set = new HashSet<>();

        distanceMap.put(head, 0);

        Node_p minNode = getMinDistanceAndUnselectedNode(distanceMap,set);

        while(minNode != null){
            Integer minDistance = distanceMap.get(minNode);
            for(Edge_p edge : minNode.edges){
                Node_p toNode = edge.to;
                if(!distanceMap.containsKey(toNode)){
                    distanceMap.put(toNode, minDistance + edge.weight);
                }else {
                    distanceMap.put(toNode, Math.min(distanceMap.get(toNode), minDistance + edge.weight));
                }
            }
            set.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap,set);
        }
        return distanceMap;
    }

    private static Node_p getMinDistanceAndUnselectedNode(HashMap<Node_p, Integer> distanceMap, HashSet<Node_p> set) {
        Node_p minNode = null;
        Integer minDistance = Integer.MAX_VALUE;

        for(Map.Entry<Node_p, Integer> entry : distanceMap.entrySet()){
            if(entry.getValue() < minDistance && !set.contains(entry.getKey())){
                minNode = entry.getKey();
                minDistance = entry.getValue();
            }
        }
        return minNode;
    }

}
