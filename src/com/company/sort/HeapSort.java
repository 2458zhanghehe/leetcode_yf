package com.company.sort;

import java.util.Arrays;

//堆和数组相对应，用堆来理解，实际操作还是在数组上
public class HeapSort {
    public static void heapySort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        while (heapSize > 0) {
            swap(arr, 0, --heapSize);
            heapify(arr, heapSize, 0);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[(index - 1) / 2] < arr[index]) {
            swap(arr, (index - 1) / 2, index);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int heapSize, int index) {
        int leftchild = 2 * index + 1;
        while (leftchild < heapSize) {
            int largest = (leftchild + 1) < heapSize && arr[leftchild + 1] > arr[leftchild] ? leftchild + 1 : leftchild;
            largest = arr[index] > arr[largest] ? index : largest;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            leftchild = 2 * index + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public static int[] generateArr(int MaxSize, int MaxValue) {
        int[] arr = new int[(int) (Math.random() * (MaxSize + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (MaxValue + 1)) - (int) (Math.random() * MaxValue);
        }
        return arr;
    }

    public static boolean isEquals(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] copyArray(int[] arr) {
        int[] copyArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copyArr[i] = arr[i];
        }
        return copyArr;
    }

    public static void main(String[] args) {
        int times = 5000;
        int MaxSize = 50;
        int MaxValue = 100;
        for (int i = 0; i < times; i++) {
            int[] arr1 = generateArr(MaxSize, MaxValue);
            int[] arr2 = copyArray(arr1);
            heapySort(arr1);
            comparator(arr2);
            if (!isEquals(arr1, arr2)) {
                System.out.println("error!");
                break;
            }
        }
    }
}
