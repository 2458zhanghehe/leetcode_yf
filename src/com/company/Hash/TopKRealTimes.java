package com.company.Hash;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

import java.util.HashMap;

public class TopKRealTimes {
    public static class TopK {
        HashMap<String, Integer> countMap;
        String[] Heap;
        int curSize = 0;
        HashMap<String, Integer> indexMap;

        public TopK(int k) {
            Heap = new String[k];
            countMap = new HashMap<>();
            indexMap = new HashMap<>();
        }

        public void insertS(String s) {
            int preIndex = -1;
            if (!countMap.containsKey(s)) {
                countMap.put(s, 1);
            } else {
                countMap.put(s, countMap.get(s) + 1);
                preIndex = indexMap.get(s);
            }
            if (preIndex == -1) {
                if (curSize == Heap.length) {
                    if (countMap.get(s) > countMap.get(Heap[0])) {
                        indexMap.put(Heap[0], -1);
                        indexMap.put(s, 0);
                        Heap[0] = s;
                        heapify(0, curSize);
                    } else {
                        indexMap.put(s, -1);
                    }
                } else {

                    Heap[curSize] = s;
                    indexMap.put(s, curSize);
                    heapyInsert(0, curSize);
                    curSize++;
                }
            } else {
                heapify(preIndex, curSize);
            }
        }

        public void heapyInsert(int index, int HeapSize) {
            int parent = (index - 1) / 2;
            while (countMap.get(Heap[parent]) > countMap.get(Heap[index])) {
                swap(parent, index);
                index = parent;
                parent = (index - 1) / 2;
            }
        }

        public void heapify(int index, int heapSize) {
            int leftC = 2 * index + 1;
            while (leftC < heapSize) {
                int min = (leftC + 1 <= heapSize && countMap.get(Heap[leftC]) > countMap.get(Heap[leftC + 1])) ? leftC + 1 : leftC;
                min = countMap.get(Heap[index]) < countMap.get(Heap[min]) ? index : min;
                if (min == index) {
                    break;
                }
                swap(min, index);
                index = min;
                leftC = 2 * index + 1;
            }
        }

        public void swap(int index1, int index2) {
            String tmp = Heap[index1];
            indexMap.put(Heap[index1], index2);
            indexMap.put(Heap[index2], index1);
            Heap[index1] = Heap[index2];
            Heap[index2] = tmp;
        }

        public String[] TopK() {
            return Heap;
        }
    }
}
