package com.company.practice2.sort2;

public class MergeSort {
    public static int[] mergeSort(int[] arr){
        if(arr == null || arr.length < 2){
            return arr;
        }
        process(arr,0,arr.length - 1);
        return arr;
    }

    public static void process(int[] arr,int L,int R){
        if(L == R){
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr,L,mid);
        process(arr,mid + 1, R);
        merge(arr,L,R,mid);
    }

    public static void merge(int[] arr, int L, int R, int mid){
        int[] help = new int[R - L + 1];
        int p1 = L;
        int p2 = mid + 1;
        int i = 0;

        while(p1 <= mid && p2 <= R){
            help[i++] = (arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++]);
        }

        while(p1 <= mid){
            help[i++] = arr[p1++];
        }

        while(p2 <= R){
            help[i++] = arr[p2++];
        }

        for(i = 0; i < help.length; i++){
            arr[L + i] = help[i];
        }
    }

    public static void mergeSort2(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        int mergeSize = 1;
        while(mergeSize < arr.length){
            int L = 0;
            while(L < arr.length){
                int mid = L + mergeSize - 1;
                if(mid > arr.length - 1){
                    break;
                }
                int R = Math.min(arr.length  - 1, mid + mergeSize);
                merge(arr,L,R,mid);
                L = R + 1;
            }
            mergeSize <<= 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,312,4,0,-5};
        mergeSort2(arr);
        for(int i : arr){
            System.out.println(i);
        }
    }
}
