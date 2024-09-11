package com.company.practice.Hash;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKTimes_p {
    public static class Node {
        public String s;
        public int counts;

        public Node(String s, int counts) {
            this.s = s;
            this.counts = counts;
        }
    }

    public static String[] topKTimes_p(String[] sArr, int k) {
        HashMap<String, Integer> countMap = new HashMap<>();
        k = Math.min(sArr.length, k);
        for (String stmp : sArr) {
            if (!countMap.containsKey(stmp)) {
                countMap.put(stmp, 1);
            } else {
                countMap.put(stmp, countMap.get(stmp) + 1);
            }
        }
        PriorityQueue<Node> ansPQ = new PriorityQueue<>(new MyComparator());
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            Node cur = new Node(entry.getKey(), entry.getValue());
            if (ansPQ.size() == k) {
                if (entry.getValue() > ansPQ.peek().counts) {
                    ansPQ.poll();
                    ansPQ.add(cur);
                }
            } else {
                ansPQ.add(cur);
            }
        }
        String[] ans = new String[k];
        int i = 0;
        while (!ansPQ.isEmpty()) {
            ans[i++] = ansPQ.poll().s;
        }
        return ans;
    }

    public static class MyComparator implements Comparator<Node> {
        @Override
        public int compare(Node n1, Node n2) {
            return n1.counts - n2.counts;
        }
    }
}
