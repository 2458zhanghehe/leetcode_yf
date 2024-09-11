package com.company.Bishi.hema;

import java.util.ArrayList;
import java.util.List;

public class P3 {
    public static int countNums(int[] nums){
        int ans = 0;
        for(int num : nums){
            ans += getDivisors(num);
        }
        return ans;
    }

    private static int getDivisors(int num) {
        int count = 0;
        for (int i = 2; i < num; i++) {
            while(num != i){
                if(num % i == 0){
                    count++;
                    num = num / i;
                }else {
                    break;
                }
            }
        }
        count++;
        return count >= 3 ? 1 : 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,100};
        int count = countNums(nums);
        System.out.println(count);
    }
}
