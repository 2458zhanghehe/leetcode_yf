package com.company.Hash;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//leetcode146
class LRUCache {
    private Queue<Integer> queue;
    private HashMap<Integer,Integer> hashMap;
    private Integer capacity;

    public LRUCache(int capacity) {
        this.queue = new LinkedList<>();
        this.hashMap = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Integer ans = hashMap.get(key);
        if(ans == null){
            return -1;
        }
        refresh(key);
        return ans;
    }

    private void refresh(int key) {
        queue.remove(key);
        queue.add(key);
    }

    public void put(int key, int value) {
        if(hashMap.containsKey(key)){
            hashMap.put(key,value);
            refresh(key);
            return;
        }
        if(queue.size() >= capacity){
            Integer poll = queue.poll();
            hashMap.remove(poll);
        }
        queue.add(key);
        hashMap.put(key,value);
    }

    public static void main(String[] args) {
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(3);
//        queue.add(1);
//        boolean remove = queue.remove(3);
//        for(Integer i : queue){
//            System.out.println(queue);
//        }

        LRUCache lruCache = new LRUCache(2);
        lruCache.get(2);
        lruCache.put(2,6);
        lruCache.get(1);
        lruCache.put(1,5);
        lruCache.put(1,2);
        lruCache.get(1);
        lruCache.get(2);
    }
}