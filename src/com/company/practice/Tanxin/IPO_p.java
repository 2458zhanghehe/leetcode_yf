package com.company.practice.Tanxin;

import org.omg.CORBA.INTERNAL;

import java.util.*;

// leetcode 502题
public class IPO_p {
    public static class CostComp implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    }

    public static class ProfitCom implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < profits.length; i++) {
            list.add(new int[]{capital[i], profits[i]});
        }
        Collections.sort(list, new CostComp());
        PriorityQueue<Integer> q = new PriorityQueue<>(new ProfitCom());

        int i = 0;
        while (--k >= 0) {
            while (i < profits.length && list.get(i)[0] <= w) {
                q.add(list.get(i++)[1]);
            }
            if (q.isEmpty()) {
                break;
            }
            w += q.poll();
        }
        return w;
    }

    public static void main(String[] args) {
        int[] caption = new int[]{1, 1, 2, 2, 3, 4};
        int[] profits = new int[]{1, 4, 3, 7, 2, 10};
        int w = findMaximizedCapital(4, 1, profits, caption);
        System.out.println(w);
        PriorityQueue<Integer> p = new PriorityQueue<>();
        System.out.print(p.size());   //空即为size=0

    }
}
