package com.company.practice.Graph_p;

import com.company.Graph.Node;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_P {
    public static void bfd(Node_p node){
        Queue<Node_p> queue = new LinkedList<>();
        HashSet<Node_p> set = new HashSet<>();  //防止图有环

        queue.add(node);
        set.add(node);

        while (!queue.isEmpty()){
            Node_p cur = queue.poll();
            System.out.println(cur.value);
            for(Node_p next : node.nexts){
                if(!set.contains(next)){
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
