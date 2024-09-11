package com.company.BitOperation;

// leetcode 191 位1的个数
public class HammingWeight {
    public int hammingWeight(int n) {
        int ans = 0;
        while(n != 0){
            int mostRightOne = n & (~n + 1);
            n -= mostRightOne;
            ans++;
        }
        return ans;
    }
}
