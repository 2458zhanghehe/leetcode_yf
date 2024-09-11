package com.company.array;

import java.util.Arrays;

// LCR 186 文物朝代判断
public class CheckDynasty {
    public static boolean checkDynasty(int[] places) {
        Arrays.sort(places);
        int cur = 0;
        int nums = 0;

        for (int i = 0; i < places.length; i++) {
            if(places[i] == 0){
                nums++;
                continue;
            }
            if(cur == 0){
                cur = places[i];
                continue;
            }
            if(cur + 1 != places[i]){
                if(nums > 0){
                    nums--;
                    cur += 1;
                    i--;
                }else {
                    return false;
                }
            }else {
                cur += 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,12,0,3};
        checkDynasty(nums);
    }
}
