package com.company.slidingW;

//左34
public class MinmumSizeSubarray {
    public static int minmumsizesubarray(int[] arr, int targetSum) {
        int ans = Integer.MAX_VALUE;
        for (int L = 0, R = 0, sum = 0; R < arr.length; R++) {
            sum += arr[R];
            while (sum - arr[L] >= targetSum) {
                sum -= arr[L++];
            }
            if (sum >= targetSum) {
                ans = Math.min(ans, R - L + 1);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 5, 3, 1, 1};
        System.out.println(minmumsizesubarray(a, 11));
    }
}
