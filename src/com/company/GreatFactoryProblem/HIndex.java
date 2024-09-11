package com.company.GreatFactoryProblem;

import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {

        Arrays.sort(citations);

        int h = 0;
        for(int i = 1; i <= citations.length; i++){
            Integer letf = getMostLeft(citations, i);
            if(citations.length - letf >= i){
                h = i;
            }else {
                break;
            }
        }
        return h;
    }

    private Integer getMostLeft(int[] arr, int target) {

        int L = 0;
        int R = arr.length - 1;

        while(L < R){
            int mid = L + ((R - L) >> 1);
            if(arr[mid] >= target){
                R = mid;
            }else {
                L = mid + 1;
            }
        }
        if(arr[L] < target){
            L++;
        }
        return L;
    }
}
