package com.company.practice.sort;

public class BubbleSort_p {
    public static int[] bubbleSort_p(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 342, 1, 532};
        bubbleSort_p(arr);
        for (Integer tmp : arr) {
            System.out.print(tmp + " ");
        }
    }
}
