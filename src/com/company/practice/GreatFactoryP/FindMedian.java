package com.company.practice.GreatFactoryP;

import java.util.PriorityQueue;

public class FindMedian {
    public static class MedianFinder {
        PriorityQueue<Integer> pq_big;
        PriorityQueue<Integer> pq_samll;

        public MedianFinder() {
            pq_big = new PriorityQueue<>((a, b) -> b - a);
            pq_samll = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (pq_big.isEmpty()) {
                pq_big.add(num);
                return;
            }
            if (num >= pq_big.peek()) {
                pq_samll.add(num);
            } else {
                pq_big.add(num);
            }

            if (pq_big.size() > pq_samll.size() + 1) {
                pq_samll.add(pq_big.poll());
            }
            if (pq_big.size() + 1 < pq_samll.size()) {
                pq_big.add(pq_samll.poll());
            }
        }

        public double findMedian() {
            if (pq_big.size() == pq_samll.size() + 1) {
                return pq_big.peek();
            }
            if (pq_big.size() + 1 == pq_samll.size()) {
                return pq_samll.peek();
            }

            return (pq_big.peek() + pq_samll.peek()) / 2.0;
        }

    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        mf.addNum(3);
        System.out.println(mf.findMedian());
    }
}
