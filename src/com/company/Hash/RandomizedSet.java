package com.company.Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//leetcode 380
public class RandomizedSet {
    private HashMap<Integer,Integer> map;
    private List<Integer> list;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(!map.containsKey(val)){
            map.put(val,list.size());
            list.add(val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if(map.containsKey(val)){
            Integer index = map.get(val);
            Integer cur = list.get(list.size() - 1);
            list.set(index,cur);
            map.put(cur,index);
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        Integer index = (int)(Math.random() * list.size());
        return list.get(index);
    }
}
