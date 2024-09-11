package com.company.GreatFactoryProblem;

import java.util.Arrays;
import java.util.Comparator;

//leetcode452
public class FindMinArrowShots {
    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
               // return o1[0] - o2[0];   这样写会溢出
                return o1[0] > o2[0] ? 1:-1;
            }
        });
        int ans = 0;
        int len = points.length;
        int i = 0;
        while(i < len){
            int j = i + 1;
            while(j < len && points[j][0] <= points[i][1]){
                points[i][1] = Math.min(points[i][1],points[j][1]);
                j++;
            }
            ans++;
            i = j;
        }
        return ans;
    }




    public static void main(String[] args) {
        int[][] points = {{-2147483646,-2147483645},{2147483646,2147483647}};
        findMinArrowShots(points);
    }
}
