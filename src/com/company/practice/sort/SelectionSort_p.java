package com.company.practice.sort;

import org.omg.CORBA.INTERNAL;

public class SelectionSort_p {
    public static int[] selectSort_p(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 34, 2, 78, 5};
        selectSort_p(arr);
        for (Integer tmp : arr) {
            System.out.print(tmp + " ");
        }
    }

}
