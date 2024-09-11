package com.company.Tanxin;

import org.omg.CORBA.INTERNAL;

import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {
    public static int findMaximizedCapital(int K, int W, int[] Profits, int[] Capital) {
        PriorityQueue<int[]> p_capital = new PriorityQueue<>(new CapitalSort());
        for (int i = 0; i < Profits.length; i++) {
            p_capital.add(new int[]{Capital[i], Profits[i]});
        }
        PriorityQueue<Integer> p_profit = new PriorityQueue<>(new ProfitsSort());
        while (--K >= 0) {
            while (!p_capital.isEmpty() && p_capital.peek()[0] <= W) {
                p_profit.add(p_capital.poll()[1]);
            }
            if (!p_profit.isEmpty()) {
                W += p_profit.poll();
            } else {
                break;
            }
        }
        return W;
    }

    public static class CapitalSort implements Comparator<int[]> {
        @Override
        public int compare(int[] i, int[] j) {
            return i[0] - j[0];
        }
    }

    public static class ProfitsSort implements Comparator<Integer> {
        @Override
        public int compare(Integer i, Integer j) {
            return j - i;
        }
    }

    public static void main(String[] args) {
        int[] caption = new int[]{1, 1, 2, 2, 3, 4};
        int[] profits = new int[]{1, 4, 3, 7, 2, 10};
        int w = findMaximizedCapital(4, 1, profits, caption);
        System.out.println(w);
//        PriorityQueue<Integer> p = new PriorityQueue<>();
//        System.out.print(p.size());   //空即为size=0
    }

}
