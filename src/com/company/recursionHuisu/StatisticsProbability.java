package com.company.recursionHuisu;

import java.util.Arrays;
import java.util.HashMap;

// LCR 185 统计结果概率
public class StatisticsProbability {
    private double baseP;
    public double[] statisticsProbability(int num) {
        double[] ans = new double[num * 6 - num + 1];
        baseP = 1 / 6.0;
        for (int i = 1; i < num; i++) {
            baseP *= 1 / 6.0;
        }
        HashMap<Integer, Double> map = new HashMap<>();
        process(0, num,0, map);
        for (int i = 0; i < ans.length; i++) {
            ans[i] = map.get(i + num);
        }
        return ans;
    }

    private void process(int index, int num, int curSum, HashMap<Integer, Double> map) {
        if(index == num){
            map.put(curSum, map.getOrDefault(curSum, 0d) + baseP);
            return;
        }
        process(index + 1, num, curSum + 1, map);
        process(index + 1, num, curSum + 2, map);
        process(index + 1, num, curSum + 3, map);
        process(index + 1, num, curSum + 4, map);
        process(index + 1, num, curSum + 5, map);
        process(index + 1, num, curSum + 6, map);
    }

    //动态规划
    public double[] statisticsProbability2(int num) {
        //使用i个色子得到sum为j的概率
        double[][] dp = new double[num + 1][num * 6 + 1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1 / 6.0;
        }

        for (int i = 2; i <= num; i++) {
            for(int j = i; j <= i * 6; j++){
                for(int k = j - 1; k >= i - 1 && j - k <= 6; k--){
                    dp[i][j] += dp[i - 1][k] * (1 / 6.0);
                }
            }
        }
        double[] ans = new double[num * 6 - num + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = dp[num][i + num];
        }
        return ans;
    }

    public static void main(String[] args) {
        StatisticsProbability sp = new StatisticsProbability();
        System.out.println(Arrays.toString(sp.statisticsProbability(3)));
        System.out.println(Arrays.toString(sp.statisticsProbability2(3)));
    }
}
