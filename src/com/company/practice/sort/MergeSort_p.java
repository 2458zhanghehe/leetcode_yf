package com.company.practice.sort;

public class MergeSort_p {
    public static int[] mergeSort_p1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        process(arr, 0, arr.length - 1);
        return arr;
    }

    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int p1 = L;
        int p2 = M + 1;
        int[] help = new int[R - L + 1];
        int i = 0;
        while (p1 <= M && p2 <= R){
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M){
            help[i++] = arr[p1++];
        }
        while(p2 <= R){
            help[i++] = arr[p2++];
        }
        for(i = 0; i < help.length; i++){
            arr[L + i] = help[i];
        }
    }

    public static void mergeSort2_p(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        int N = arr.length;
        int mergeSize = 1;
        while (mergeSize < N){
            int L = 0;
            while(L < N){
                int middle = L + mergeSize - 1;
                if(middle >= N - 1){
                    break;
                }
                int R = Math.min(middle + mergeSize, N - 1);
                merge(arr,L,middle,R);
                L = R + 1;
            }
            mergeSize <<= 1;
        }

    }



    public static int[] mergeSort_p2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        int mergeSize = 1;
        int N = arr.length;
        while (mergeSize < N) {
            int L = 0;
            while (L < N) {
                int mid = L + mergeSize - 1;
                if (mid >= N) {
                    break;
                }
                int R = Math.min(N - 1, mid + mergeSize);
                merge(arr, L, mid, R);
                L = R + 1;
            }
            mergeSize <<= 1;
        }
        return arr;
    }

    public static int[] copyArr(int[] arr) {
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    public static int[] getRandomArr(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen) + 1;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * maxValue) + 1 - (int) (Math.random() * maxValue);
        }
        return arr;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
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

    public static void printArr(int[] arr) {
        for (Integer tmp : arr) {
            System.out.print(tmp + " ");
        }
    }

    public static void main(String[] args) {

        int maxLen = 100;
        int maxValue = 100;
        for (int i = 0; i < 1000; i++) {
            int[] arr1 = getRandomArr(maxLen, maxValue);
            int[] arr2 = copyArr(arr1);
            mergeSort_p1(arr1);
            mergeSort_p2(arr2);
            if (!isEqual(arr1, arr2)) {
                System.out.println("出错！");
                printArr(arr1);
                System.out.println();
                printArr(arr2);
                break;
            }
        }
    }
}
