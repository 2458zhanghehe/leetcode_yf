package com.company.Bishi.dianxin;

public class P1 {
    public static double getValue (int a, int b) {
        if(a == 0){
            if(b == 1){
                return 99999.0;
            }else {
                return -1.0;
            }
        }
        if(b == 1){
            return 0.0;
        }
        double ans = (1 - b) / (1.0 * a);
        ans = Math.round(ans * 10) / 10.0;
        return ans;
    }
}
