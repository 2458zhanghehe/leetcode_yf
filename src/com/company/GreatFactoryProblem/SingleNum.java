package com.company.GreatFactoryProblem;

//leetcode 137 只出现一次的数字2
public class SingleNum {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 0; i < 32; i++){
            int cnt = 0;
            for(int num : nums){
                cnt += (num >> i)&1;
            }

            if(cnt % 3 != 0){
                ans |= 1<<i;
            }
        }
        return ans;
    }
}
