package com.company.math;

// leetcode 400 第N位数字
public class FindNthDigit {
    public static int findNthDigit(int n) {
        int tmp = 9;
        int index = 1;
        int cur = 0;
        while(cur + index * tmp < n){
            cur += index * tmp;
            index++;
            tmp *= 10;
        }

        tmp /= 10;

        int delta = (n - tmp) / index;
        int yu = (n - tmp) % index;

        if(yu == 0){
            String dst = String.valueOf(tmp + delta);
            return dst.charAt(dst.length() - 1) - '0';
        }else {
            String dst = String.valueOf(tmp + delta + 1);
            return dst.charAt(yu - 1) - '0';
        }
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(9));
    }
}
