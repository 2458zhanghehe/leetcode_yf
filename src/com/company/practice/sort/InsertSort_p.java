package com.company.practice.sort;

import static com.company.practice.sort.BubbleSort_p.swap;

public class InsertSort_p {
    public static int[] insertSort_p(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for(int j=i; j >= 1 && arr[j] < arr[j - 1];j--){
                swap(arr,j,j-1);
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] arr = {10, 3, 5, 2};
        insertSort_p(arr);
        for (Integer tmp : arr) {
            System.out.print(tmp + " ");
        }
    }
}
