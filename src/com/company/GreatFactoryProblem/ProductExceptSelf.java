package com.company.GreatFactoryProblem;

//leetcode 238
public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] ans = new int[N];

        ans[0] = 1;
        int tmp = 1;
        for(int i = 1; i < N - 1; i++){
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        for(int i = N - 2; i >= 0; i--){
            tmp *= nums[i + 1];
            ans[i] *= tmp;
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        productExceptSelf(a);
    }
}
