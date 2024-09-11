package com.company.Bishi.zhongan;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamTest {
    public static List<Integer> removeOu(List<Integer> nums){
        List<Integer> ans = nums.stream().filter(integer -> {
            if ((integer & 1) == 1) {
                return true;
            } else {
                return false;
            }
        }).collect(Collectors.toList());
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            nums.add(i);
        }
        List<Integer> ans = removeOu(nums);
        System.out.println(ans);
    }
}
