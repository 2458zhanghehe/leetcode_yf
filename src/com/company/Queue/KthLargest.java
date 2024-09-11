package com.company.Queue;

import java.util.ArrayList;
import java.util.PriorityQueue;

//leetcode 703 数据流中第K大的元素
class KthLargest {
    private PriorityQueue<Integer> priorityQueue;
    private int size;
    public KthLargest(int k, int[] nums) {
        priorityQueue = new PriorityQueue<>();
        size = k;
        for(int num : nums){
            if(priorityQueue.size() <size){
                priorityQueue.add(num);
            }else if(priorityQueue.peek() < num){
                priorityQueue.poll();
                priorityQueue.add(num);
            }
        }
    }
    
    public int add(int val) {
        if(priorityQueue.size() < size){
            priorityQueue.add(val);
        }else if(priorityQueue.peek() < val){
            priorityQueue.poll();
            priorityQueue.add(val);
        }
        return priorityQueue.peek();
    }
}