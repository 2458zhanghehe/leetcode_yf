package com.company.slidingW;

public class GasStation {
    public static int gasS(int[] gas, int[] road) {
        int gas_nums = gas.length;
        for (int L = 0, R = 0, len = 0, sum = 0; L < gas.length; L++) {
            while (sum >= 0) {
                if (len == gas_nums) {
                    return L;
                }
                R = (L + len++) % gas_nums;
                sum += gas[R] - road[R];

            }
            sum -= gas[L] - road[L];
            len--;
        }
        return -1;
    }
}
