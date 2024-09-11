package com.company.Bishi;

import java.util.Arrays;

public class GrayCode {

    public static String[] grayCode(int n){
        if(n <= 0){
            return new String[0];
        }
        return process(n);
    }

    private static String[] process(int n){
        if(n == 1){
            return new String[]{"0", "1"};
        }

        String[] cur = process(n - 1);
        String[] ans = new String[2 * cur.length];

        for (int i = 0; i < cur.length; i++) {
            ans[i] = "0" + cur[i];
            ans[ans.length - 1 - i] = "1" + cur[i];
        }
        return ans;
    }


    public static void main(String[] args) {
        String[] ans = grayCode(3);
        System.out.println(Arrays.toString(ans));
    }
}
