package com.company.GreatFactoryProblem;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//leetcode 80
public class RemoveDuplicates2 {

    //自己想的
    public static int removeDuplicates(int[] nums) {
        int cnt = 1;
        int pre = nums[0];

        int N = nums.length;
        for(int i = 1; i < N; i++){
            if(nums[i] == pre){
                cnt++;
                if(cnt > 2){
                    for(int j = i; j < N - 1; j++){
                        nums[j] = nums[j + 1];
                    }
                    N -= 1;
                    i--;
                    cnt--;
                }else {
                    continue;
                }
            }else {
                cnt = 1;
                pre = nums[i];
            }
        }
        return N;
    }

    //双指针法
    public static int removeDuplicates2(int[] nums) {
        if(nums.length < 3){
            return nums.length;
        }
        int p1 = 2;
        int p2 = 2;

        while(p2 < nums.length){
            if(nums[p1 - 2] != nums[p2]){
                nums[p1++] = nums[p2++];
            }else{
                p2++;
            }
        }
        return p1;
    }

    public static void main(String[] args) {
        int[] a = {1,1,1,2,2,3};
        int N = removeDuplicates(a);
        System.out.println(N);

    }
}
