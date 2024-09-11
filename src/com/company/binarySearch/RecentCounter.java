package com.company.binarySearch;

import org.apache.catalina.LifecycleState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//LCR 042 最近请求次数
class RecentCounter {

    // 在0到毫秒请求次数
    private HashMap<Integer, Integer> prefixMap;
    //key队列
    private List<Integer> list;

    public RecentCounter() {
        prefixMap = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public int ping(int t) {
        if(list.size() == 0){
            prefixMap.put(t, 1);
            list.add(t);
            return 1;
        }

        Integer lastT = list.get(list.size() - 1);
        Integer prePingSum = prefixMap.get(lastT);
        prefixMap.put(t, prePingSum + 1);
        list.add(t);
        int leftIndex = getLeft(t - 3000);
        if(leftIndex == 0){
            return prePingSum + 1;
        }
        int leftKey = list.get(leftIndex - 1);
        return prePingSum + 1 - prefixMap.get(leftKey);
    }

    private int getLeft(int i) {
        int left = 0;
        int right = list.size() - 1;
        while(left <= right){
            int mid = ((right - left) >> 1) + left;
            Integer cur = list.get(mid);
            //题目保证了t是单调递增的
            if(cur > i){
                right = mid - 1;
            }else if(cur == i){
                return mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}