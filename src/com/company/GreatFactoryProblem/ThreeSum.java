package com.company.GreatFactoryProblem;

import javax.management.MBeanRegistration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int L = i + 1;
            int R = nums.length - 1;

            int target = 0 - nums[i];
            while(L < R){
                if(nums[L] + nums[R] == target){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    result.add(list);
                    while(nums[++L] == nums[L - 1]){
                        if(L >= nums.length - 1){
                            break;
                        }
                    }
                    while(nums[--R] == nums[R + 1]){
                        if(R <=0){
                            break;
                        }
                    }

                }else if(nums[L] + nums[R] > target){
                    R--;
                }else {
                    L++;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        HashSet<List<Integer>> set = new HashSet<>();

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        list1.add(1);
        list2.add(1);

        boolean equals = list1.equals(list2);
        System.out.println(equals);

        set.add(list1);
        set.add(list2);
    }
}
