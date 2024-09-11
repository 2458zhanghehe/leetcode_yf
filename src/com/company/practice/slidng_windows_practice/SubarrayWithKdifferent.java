package com.company.practice.slidng_windows_practice;

import java.util.Arrays;

public class SubarrayWithKdifferent {
    public static int SWK(int[] arr, int k) {
        System.out.println(numsofMostK(arr, k));
        System.out.println(numsofMostK(arr, k - 1));
        return numsofMostK(arr, k) - numsofMostK(arr, k - 1);
    }

    public static int[] cnts = new int[20001];

    public static int numsofMostK(int[] arr, int k) {
        Arrays.fill(cnts, 1, arr.length + 1, 0);
        int ans = 0;
        for (int l = 0, r = 0, collect = 0; r < arr.length; r++) {
            if (++cnts[arr[r]] == 1) {
                collect++;
            }
            while (collect > k) {
                if (--cnts[arr[l++]] == 0) {
                    collect--;
                }
            }
            ans += r - l + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 1, 2, 3};
        System.out.print(SWK(arr, 2));
    }
}
