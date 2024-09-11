package com.company.Bishi.meituan.day0406;


import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] preSumB = new long[n - 1];
        long[] preSumC = new long[n - 1];
        for(int i = 0; i < n - 1; i++){
            preSumB[i] = sc.nextLong();
        }
        for(int i = 0; i < n - 1; i++){
            preSumC[i] = sc.nextLong();
        }
        Arrays.sort(preSumB);
        Arrays.sort(preSumC);

        long[] nums = new long[n];
        HashSet<Long> set = new HashSet<>();

        long[] numsB = new long[n - 1];
        long[] numsC = new long[n - 1];
        HashMap<Long, Integer> mapC = new HashMap<>();
        numsB[0] = preSumB[0];
        numsC[0] = preSumC[0];
        mapC.put(numsC[0],0);

        for(int i = 1; i < n - 1; i++){
            numsB[i] = preSumB[i] - preSumB[i - 1];
            numsC[i] = preSumC[i] - preSumC[i - 1];
            mapC.put(numsC[i], i);
        }

        int j = 0;
        for(int i = 0; i < n - 1; i++){
            if(!set.contains(numsB[i])){
                Integer index = mapC.getOrDefault(numsB[i], -1);
                if(index == -1 || index <= i){
                    nums[j++] = numsB[i];
                    set.add(numsB[i]);
                    if(!set.contains(numsC[i])){
                        nums[j++] = numsC[i];
                        set.add(numsC[i]);
                    }
                }else {
                    if(!set.contains(numsC[i])){
                        nums[j++] = numsC[i];
                        set.add(numsC[i]);
                    }
                    nums[j++] = numsB[i];
                    set.add(numsB[i]);
                }
            }else if(!set.contains(numsC[i])){
                set.add(numsC[i]);
                nums[j++] = numsC[i];
            }
        }

        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
