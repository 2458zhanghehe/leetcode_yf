package com.company.GreatFactoryProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//leetcode 030
public class RandomizedSet {

    //val index
    HashMap<Integer, Integer> map;
    List<Integer> list;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }else {
            map.put(val,list.size());
            list.add(val);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)){
            Integer index = map.get(val);
            int tmp = list.get(list.size() - 1);
            list.set(index,tmp);
            list.remove(list.size() - 1);
            map.put(tmp,index);
            map.remove(val);
            return true;
        }else {
            return false;
        }

    }

    /** Get a random element from the set. */
    public int getRandom() {
        int rand = (int) (Math.random() * list.size());
        return list.get(rand);
    }
}
