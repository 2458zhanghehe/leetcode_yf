package com.company.practice.sort;

import static com.company.practice.sort.BubbleSort_p.swap;

public class HeapSort_p {
    public static void heapSort_p(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i - 1);
        }
    }

    public static void heapify(int[] arr, int index, int heapSize) {
        int leftC = 2 * index + 1;
        while (leftC <= heapSize) {
            int largest = ((leftC + 1 <= heapSize) && (arr[leftC + 1] > arr[leftC])) ? leftC + 1 : leftC;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            leftC = 2 * index + 1;
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[(index - 1) / 2] < arr[index]) {
            swap(arr, (index - 1) / 2, index);
            index = (index - 1) / 2;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 4, 8};
        heapSort_p(arr);
        for (int tmp : arr) {
            System.out.print(tmp + " ");
        }
    }
}
