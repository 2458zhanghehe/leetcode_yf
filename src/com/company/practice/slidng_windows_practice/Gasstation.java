package com.company.practice.slidng_windows_practice;

public class Gasstation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int gas_nums = gas.length;
        for (int l = 0, r = 0, len = 0, sum = 0; l < gas_nums; l++) {
            while (sum >= 0) {
                if (len == gas_nums) {
                    return l;
                }
                r = (l + len) % gas_nums;
                sum += gas[r] - cost[r];
                len++;
            }
            sum -= gas[l] - cost[l];
            len--;
        }
        return -1;
    }
}

