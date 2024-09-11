package com.company.array;

// LCR 170 交易逆序对的总数
public class ReversePairs {

    //超时
    public int reversePairs(int[] record) {
        int ans = 0;
        for (int i = 0; i < record.length; i++) {
            for (int j = i + 1; j < record.length; j++) {
                if(record[i] > record[j]){
                    ans++;
                }
            }
        }
        return ans;
    }
}
