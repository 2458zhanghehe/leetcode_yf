package com.company.Hash;

import java.util.HashMap;
import java.util.Map;

// LCR 178 训练计划 VI
public class TrainingPlan {
    public int trainingPlan(int[] actions) {
        // values : counts
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int action : actions){
            map.put(action, map.getOrDefault(action, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return -1;
    }
}
