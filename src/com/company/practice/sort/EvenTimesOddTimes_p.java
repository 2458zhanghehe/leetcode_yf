package com.company.practice.sort;

public class EvenTimesOddTimes_p {
    public static void printOddTimesNum1(int[] arr) {
        int num = 0;
        for (Integer tmp : arr) {
            num ^= tmp;
        }
        System.out.println(num);
    }

    public static void printOddTimesNum2(int[] arr) {
        int num = 0;
        for (Integer tmp : arr) {
            num ^= tmp;
        }
        int mostrightOne = num & (~num + 1);
        int num2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & mostrightOne) != 0) {
                num2 ^= arr[i];
            }
        }
        System.out.print(num2 + "  " + (num2 ^ num));
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 8};
        printOddTimesNum1(arr);
        int[] arr2 = {1, 1, 2, 2, 3, 4, 4, 5};
        printOddTimesNum2(arr2);
    }
}
