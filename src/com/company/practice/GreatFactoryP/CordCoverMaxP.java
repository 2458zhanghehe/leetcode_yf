package com.company.practice.GreatFactoryP;

import java.util.Arrays;

public class CordCoverMaxP {
    public static int CCMP1(int[] arr, int len) {
        int ans = -1;
        for (int i = 0; i < arr.length; i++) {
            int left = process(arr, arr[i] - len, i);
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }

    public static int process(int[] arr, int target, int R) {
        int l = 0;
        int r = R;
        int mid = 0;
        int left = -1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (arr[mid] >= target) {
                left = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return left;
    }

    public static int CCMP2(int[] arr, int len) {
        int ans = 0;
        for (int l = 0, r = 0; r < arr.length; r++) {
            while (arr[r] - arr[l] > len) {
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    public static int[] generatearray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * maxSize) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue));
        }
        Arrays.sort(arr);
        return arr;
    }

    public static void main(String[] args) {
        int times = 1000;
        int maxsize = 100;
        int maxvalue = 1000;
        for (int i = 0; i < times; i++) {
            int[] arr = generatearray(maxsize, maxvalue);
            int len = (int) (Math.random() * maxvalue);

            if (CCMP1(arr, len) != CCMP2(arr, len)) {

                System.out.println("error");
                break;
            }
        }
    }
}
