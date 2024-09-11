package com.company.Hash;

import org.omg.CORBA.INITIALIZE;
import org.omg.CORBA.INTERNAL;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKTimes {
    public static class Node {
        String s;
        int counts;

        public Node(String s, int counts) {
            this.s = s;
            this.counts = counts;
        }
    }

    public static class MyComparator implements Comparator<Node> {
        @Override
        public int compare(Node n1, Node n2) {
            return n1.counts - n2.counts;
        }
    }

    public static String[] topKTimes(String[] arrs, int topK) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : arrs) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }
        topK = Math.min(arrs.length, topK);
        PriorityQueue<Node> heap = new PriorityQueue<Node>(new MyComparator());

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Node cur = new Node(entry.getKey(), entry.getValue());
            if (heap.size() < topK) {
                heap.add(cur);
            } else {
                if (cur.counts > heap.peek().counts) {
                    heap.poll();
                    heap.add(cur);
                }
            }
        }
        String[] ans = new String[heap.size()];
        int i = 0;
        while (!heap.isEmpty()) {
            Node tmp = heap.poll();
            ans[i++] = tmp.s;
        }
        return ans;
    }
}
