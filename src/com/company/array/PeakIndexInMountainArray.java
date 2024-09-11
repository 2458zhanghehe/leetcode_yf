package com.company.array;

//LCR 069 山脉数组的峰顶索引
public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int L = 0;
        int R = arr.length - 1;
        while(L < R){
            int mid = L + ((R - L) >> 1);
            if(arr[mid] < arr[mid + 1]){
                L = mid + 1;
            }else {
                R = mid;
            }
        }
        return L;
    }
}
