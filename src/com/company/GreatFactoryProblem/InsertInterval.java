package com.company.GreatFactoryProblem;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;

        List<int[]> list = new ArrayList<>();


        int i = 0;

        while(i < len && intervals[i][1] < newInterval[0]){
            list.add(intervals[i]);
            i++;
        }
        if(i < len){
            int L = Math.min(intervals[i][0],newInterval[0]);
            int R = newInterval[1];

            while(i < len && intervals[i][0] <= newInterval[1]){
                R = Math.max(intervals[i][1], newInterval[1]);
                i++;
            }
            list.add(new int[]{L,R});
        }else {
            list.add(newInterval);
        }

        while(i < len){
            list.add(intervals[i]);
            i++;
        }

        return list.toArray(new int[list.size()][2]);
    }
}
