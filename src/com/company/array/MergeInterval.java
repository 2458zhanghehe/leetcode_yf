package com.company.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

//leetcode 56  合并区间
public class MergeInterval {

    public static class MyComapator implements Comparator<int[]>{
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
        }
    }

    public static int[][] merge(int[][] intervals){
        Arrays.sort(intervals, new MyComapator());

        ArrayList<int[]> list = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++){
            while(i + 1 < intervals.length && intervals[i][1] >= intervals[i + 1][0]){
                intervals[i + 1][0] = Math.min(intervals[i][0] ,intervals[i + 1][0]);
                intervals[i + 1][1] = Math.max(intervals[i][1] ,intervals[i + 1][1]);
                i++;
            }
            list.add(new int[]{intervals[i][0],intervals[i][1]});
        }

        //List转为array
        int[][] ans = list.toArray(new int[list.size()][2]);
        return ans;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{2,6},{1,3}};
        int[][] merge = merge(intervals);
        for(int[] cur : merge){
            System.out.println(cur[0] + "--" + cur[1]);
        }


        int[] a = new int[]{1,2};
        int[] b = new int[]{1,2};

        HashSet<int[]> set = new HashSet<>();
        set.add(a);
        set.add(b);
        System.out.println(set.size());

    }
}
