package com.company.practice2.sort2;

public class InsertedSort {
    public static void insertSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            for(int j = i - 1; j >= 0 && arr[j + 1] < arr[j]; j--){
                swap(arr, j + 1, j);
            }
        }
    }


    public static void swap(int[] arr,int i,int j){
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }
}
