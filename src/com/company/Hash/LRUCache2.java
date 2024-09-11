package com.company.Hash;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache2 extends LinkedHashMap<Integer,Integer>{
    private int capacity;

    public LRUCache2(int capacity){
        //LinkedHashMap的排序方式有两种，一种是根据写入的顺序排序，第二种是根据访问的顺序排序
        //主要是为了配置true使得按访问顺序排
        super(capacity,0.75F,true);
        this.capacity = capacity;
    }

    public int get(int key){
        return super.getOrDefault(key,-1);
    }

    public void put(int key, int value){
        super.put(key,value);
    }

    //通过覆盖这个方法，加入一定的条件，满足条件返回true。当put进新的值方法返回true时，便移除该map中最老的键和值。
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return super.size() > capacity;
    }
}
