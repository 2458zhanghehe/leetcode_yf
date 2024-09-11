package com.company.Bishi.jwhr_bi;

public class P2 {
    public static double calSqrt (double number) {
        double low = 0;
        double high = number;
        double delta = 1e-6;
        double mid = 0d;
        while(high - low > delta){
            mid = (high - low)/2.0 + low;
            double cur = mid * mid;
            if(cur > number){
                high = mid;
            }else if(cur < number){
                low = mid;
            }else {
                return mid;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(calSqrt(9));
    }
}
