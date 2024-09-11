package com.company.binarySearch;

//leetcode 29 两数相除   二分搜索+倍增乘法
public class Divide {
    public static int divide1(int dividend, int divisor) {
        if(divisor == 1){
            return dividend;
        }
        if(divisor == -1){
            if(dividend >= 0){
                return -dividend;
            }else {
                return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
            }
        }

        if(divisor == Integer.MAX_VALUE){
            if(dividend == Integer.MAX_VALUE){
                return 1;
            }else if (dividend < Integer.MIN_VALUE + 2){
                return -1;
            }else {
                return 0;
            }
        }

        if(divisor == Integer.MIN_VALUE){
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }

        int ans = 0;
        if(dividend == Integer.MIN_VALUE){
            ans++;
            dividend += divisor < 0 ? -divisor : divisor;
        }
        boolean fu = false;
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)){
            fu = true;
        }
        dividend = dividend < 0 ? -dividend : dividend;
        divisor = divisor < 0 ? -divisor : divisor;
        while(dividend >= divisor && ans < Integer.MAX_VALUE){
            dividend -= divisor;
            ans++;
        }
        return fu ? -ans : ans;
    }



    public static int divide2(int dividend, int divisor) {
        long a = dividend;
        long b = divisor;
        boolean neg = false;
        if((a > 0 && b < 0) || (a < 0 && b > 0)){
            neg = true;
        }
        a = a < 0 ? -a : a;
        b = b < 0 ? -b : b;
        long left = 0;
        long right = a;
        long mid;

        //小于等于的最右边界
        while(left < right){
            mid = left + ((right - left + 1) >> 1);
            if(mul(mid , b) > a){
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        long ans = neg ? -left : left;
        if(ans > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        return (int)ans;
    }

    //倍增乘法  不给用*时很好用
    private static long mul(long x, long y) {
        long ans = 0;
        while(y > 0){
            if((y & 1) == 1){
                ans += x;
            }
            y >>= 1;
            x += x;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(divide2(10, 3));
    }
}
