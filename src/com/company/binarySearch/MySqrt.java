package com.company.binarySearch;

//leetcode69 x的平方根
public class MySqrt {
    public static int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        if(x < 4){
            return 1;
        }
        if(x < 9){
            return 2;
        }
        int L = 2;
        int R = Math.min(x/2, 46340);
        while(L <= R){
            int mid = ((R - L) >> 1) + L;
            int tmp = mid * mid;
            if(tmp > x){
                R = mid;
            }else if(tmp < x){
                L = mid;
            }else {
                return mid;
            }
            if(R - L == 1){
                return R*R <= x ? R : L;
            }
        }
        return L;
    }

    public static void main(String[] args) {
        int i = 8192;
        int i1 = mySqrt(i);
        System.out.println(i1);
    }
}
