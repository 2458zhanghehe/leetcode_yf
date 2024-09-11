package com.company.array;
//给定一个数组，如果通过调整可以使得该数组中任意两个相邻元素的成绩是4的倍数，返回true，否则返回false
// zuo 112
public class NeighbourFor4 {
    public static boolean neighbourFor4(int[] nums){
        if(nums == null || nums.length < 2){
            return false;
        }
        int cntJi = 0;
        int cntOnly2 = 0;
        int cnt4 = 0;

        for(int tmp : nums){
            if((tmp & 1) == 1){
                cntJi++;
            }else if(tmp % 4 == 0){
                cnt4++;
            }else {
                cntOnly2++;
            }
        }

        if(cntOnly2 == 0){
            if(cntJi == 1){
                return cnt4 >= 1;
            }else {
                return cnt4 >= cntJi - 1;
            }
        }else {
            return cnt4 >= cntJi;
        }
    }
}
