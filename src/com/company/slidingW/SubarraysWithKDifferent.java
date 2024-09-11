package com.company.slidingW;

import java.util.Arrays;

//左40
public class SubarraysWithKDifferent {
    public static int SWD(int[] arr, int k) {

        return numsOfMostKinds(arr, k) - numsOfMostKinds(arr, k - 1);
    }

    public static int MAXN = 20001;
    public static int[] cnts = new int[MAXN];

    //假设arr中的数值范围1-20000
    public static int numsOfMostKinds(int[] arr, int k) {
        Arrays.fill(cnts, 1, arr.length + 1, 0);
        int ans = 0;
        for (int l = 0, r = 0, collect = 0; r < arr.length; r++) {
            if (cnts[arr[r]]++ == 0) {
                collect++;
            }
            while (collect > k) {
                if (--cnts[arr[l++]] == 0) {
                    collect--;
                }
            }
            ans += r - l + 1;
            //以r结尾的子序列 0-3 1-3 2-3 3-3
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 1, 2, 3, 1};
        System.out.println(SWD(a, 2));


        int i = 0;
        if(i++ == 0){
            System.out.println(i);
        }
    }
}
