package com.company.practice.slidng_windows_practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LongSubStringWithoutRepeating {
    public static int Lss(String s) {
        char[] s_char = s.toCharArray();
        int[] lastLocation = new int[256];
        Arrays.fill(lastLocation, -1);
        int ans = 0;
        for (int L = 0, R = 0; R < s_char.length; R++) {
            L = Math.max(L, lastLocation[s_char[R]] + 1);
            ans = Math.max(ans, R - L + 1);
            lastLocation[s_char[R]] = R;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = " ";
        int a = Lss(s);
        System.out.println(a);
    }

}
