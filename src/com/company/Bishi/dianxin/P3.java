package com.company.Bishi.dianxin;

public class P3 {
    public int minOperation (int[] a, int[] b) {
        int MaxA = Integer.MIN_VALUE;
        for(int cur : a){
            MaxA  =Math.max(cur, MaxA);
        }

        int ans = 0;
        for(int cur : b){
            if(cur < MaxA){
                ans += MaxA - cur;
            }
        }
        return ans;
    }
}
