package com.company.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    //无向图，从点node进行宽度遍历。  如果图有多个子图，要求全遍历，则需要对每个node进行一次bfs
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    queue.add(next);
                    set.add(next);
                }
            }
        }
    }
}
