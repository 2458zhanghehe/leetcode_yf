package com.company.array;

//子数组的最大累加和
public class SubArrMaxSum {
    public int subArrMaxSum(int[] arr){
        int cur = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            cur += arr[i];
            max = Math.max(max, cur);
            if(cur < 0){
                cur = 0;
            }
        }
        return max;
    }
}
