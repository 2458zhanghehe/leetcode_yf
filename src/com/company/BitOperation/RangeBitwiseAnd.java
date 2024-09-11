package com.company.BitOperation;

//leetcode 201
public class RangeBitwiseAnd {
    public static int rangeBitwiseAnd(int left, int right) {
        if(left == Integer.MAX_VALUE){
            return left;
        }
        int ans = left;
        for(int i = left + 1; i <= right; i++){
            ans &= i;
            if(ans == 0 || i == Integer.MAX_VALUE){
                break;
            }
        }
        return ans;
    }

    public static int rangeBitwiseAnd2(int left, int right) {
        if(left == Integer.MAX_VALUE){
            return left;
        }

        int max = find(left);

        if(max <= right && max != Integer.MAX_VALUE){
            return 0;
        }

        int ans = left;

        for(int i = left + 1; i <= max && i <= right; i++){
            ans &= i;
            if(ans == 0 || i == Integer.MAX_VALUE){
                break;
            }
        }
        return ans;
    }

    private static int find(int left) {
        int tmp = 1;
        while(left >= tmp){
            if(tmp == 1 << 30){
                return Integer.MAX_VALUE;
            }
            tmp = tmp << 1;
        }
        return tmp;
    }


    public static int rangeBitwiseAnd3(int left, int right) {
        int zeros = 0;
        while(left < right){
            left >>= 1;
            right >>= 1;
            zeros++;
        }
        return right << zeros;
    }


    public static void main(String[] args) {
        rangeBitwiseAnd(2147483646,2147483647);
    }
}
