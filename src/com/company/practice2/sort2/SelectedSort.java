package com.company.practice2.sort2;

import java.util.Arrays;

public class SelectedSort {

    public static void selectedSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int minIndex = i;
            for(int j = i; j < arr.length; j++){
               if(arr[j] < arr[minIndex]){
                   minIndex = j;
               }
            }
            swap(arr,minIndex,i);
        }


    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }


    public static void main(String[] args) {
        int[] arr = {1,3243,453,12,-2};
        selectedSort(arr);
        for(int i : arr){
            System.out.println(i);
        }
    }

}
