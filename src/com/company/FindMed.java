package com.company;

import org.omg.CORBA.INTERNAL;

import java.util.PriorityQueue;

public class FindMed {

    public static class MedianFinder {
        private PriorityQueue<Integer> p_small;
        private PriorityQueue<Integer> p_big;

        public MedianFinder() {
            p_small = new PriorityQueue<>();
            p_big = new PriorityQueue<>((a, b) -> b - a);
        }

        public void addNum(int num) {
            if (p_big.isEmpty()) {
                p_big.add(num);
                return;
            }
            if (num < p_big.peek()) {
                p_big.add(num);
            } else {
                p_small.add(num);
            }
            if (p_small.size() > p_big.size() + 1) {
                p_big.add(p_small.poll());
            }
            if (p_big.size() > p_small.size() + 1) {
                p_small.add(p_big.poll());
            }
        }

        public double findMedian() {
            if (p_small.size() > p_big.size()) {
                return p_small.peek();
            }
            if (p_small.size() < p_big.size()) {
                return p_big.peek();
            }
            return (p_small.peek() + p_big.peek()) / 2.0;
        }
    }


    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(3);
        mf.addNum(5);
        mf.addNum(6);
        mf.addNum(7);
        mf.addNum(9);
        System.out.print(mf.findMedian());
    }
}
