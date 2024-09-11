package com.company.GreatFactoryProblem;

//leetcode66
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        while(digits[index] == 9){
            digits[index] = 0;
            index--;
            if(index < 0){
                int[] ans = new int[digits.length + 1];
                ans[0] = 1;
                return ans;
            }
        }
        digits[index]++;
        return digits;
    }
}
