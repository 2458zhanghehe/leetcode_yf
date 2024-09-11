package com.company.slidingW;

public class SlidingWindowMaxArray {

    //手写双端队列
    public static class doublelist {
        public int[] arr;
        public int[] queue;
        public int l;
        public int r;
        public int lq;
        public int rq;

        public doublelist(int[] a) {
            arr = a;
            queue = new int[a.length];
            l = 0;
            r = 0;
            lq = 0;
            rq = 0;
        }

        public void add() {
            if (r == arr.length) {
                return;
            }
            while (rq != lq && arr[queue[rq - 1]] <= arr[r]) {
                rq--;
            }
            queue[rq++] = r++;
        }

        public void remove() {
            if (l == r) {
                return;
            }
            if (queue[lq] == l) {
                lq++;
            }
            l++;
        }

        public int max() {
            if (lq == rq) {
                return -1;
            }
            return arr[queue[lq]];
        }
    }
}
