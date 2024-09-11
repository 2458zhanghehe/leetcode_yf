package com.company.practice2.sort2;

public class BubbleSort {

    public static void bubble(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = arr.length - 1; j > i; j--){
                if(arr[j] < arr[j - 1]){
                    swap(arr,j,j-1);
                }
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }


    public static void main(String[] args) {
        int[] arr = {1,32,5,32,7};
        bubble(arr);
        for(int i : arr){
            System.out.println(i);
        }
    }


}
