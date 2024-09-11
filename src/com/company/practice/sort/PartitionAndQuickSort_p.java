package com.company.practice.sort;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Map;

import static com.company.practice.sort.BubbleSort_p.swap;

public class PartitionAndQuickSort_p {
    public static int partition(int[] arr, int L, int R) {
        if (L == R) {
            return L;
        }
        int smaller = L - 1;
        int index = L;
        while (index <= R) {
            if (arr[index] <= arr[R]) {
                swap(arr, index, ++smaller);
            }
            index++;
        }
        return smaller;
    }

    public static int[] isLand(int[] arr, int L, int R) {
        int smaller = L - 1;
        int lager = R;
        int index = L;
        while (index < lager) {
            if (arr[index] < arr[R]) {
                swap(arr, index++, ++smaller);
            } else if (arr[index] > arr[R]) {
                swap(arr, index, --lager);
            } else {
                index++;
            }
        }
        swap(arr, index, R);
        return new int[]{smaller, lager + 1};
    }


    public static void quickSort3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int rand = (int) (Math.random() * (R - L + 1));
        swap(arr, L + rand, R);
        int[] smallAndLarge = isLand(arr, L, R);
        process(arr, L, smallAndLarge[0]);
        process(arr, smallAndLarge[1], R);
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 10, 5, 6};
        quickSort3(arr);
        for (Integer tmp : arr) {
            System.out.print(tmp + " ");
        }
    }
}
