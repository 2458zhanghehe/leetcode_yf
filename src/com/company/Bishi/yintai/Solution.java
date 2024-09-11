package com.company.Bishi.yintai;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param a int整型一维数组 
     * @param b int整型一维数组 
     * @return long长整型
     */
    public static long pairNumbers (int[] a, int[] b) {
        int n = b.length;
        long ans = 0;
        for(int i = 0; i < n - 1; i++){
            for(int j = n - 1; j > i; j--){
                if(a[i] + b[j] > b[i] + a[j]){
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {3,3,1,4,5};
        int[] b = {1,5,2,4,3};
        System.out.println(pairNumbers(a,b));
    }
}