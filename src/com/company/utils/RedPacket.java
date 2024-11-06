package com.company.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RedPacket {
    public double[] redPacket(double res, int number){
        double min = 0.01; // 假设最小金额，正整数，或0.1或0.xx1等可被1整除的小数

        if(number * min > res){
            throw new IllegalArgumentException("钱不够，请减少金额或缩小最小值");
        }
        // 如果最小金额是小数，算出需扩大倍数，否则倍数为1
        int beiShu;
        if(min > 1){
            beiShu = 1;
        }else{
            beiShu = (int) (1 / min);
        }
        // 扩大后的总数、扩大后的最小值、扩大后的每个红包金额数
        int t_total = (int) (res * beiShu);
        int t_min = (int) (min * beiShu);

        int[] thb = new int[number];
        Arrays.fill(thb, t_min);  // 填充最小值
        // 可分配金额
        t_total -= (number * t_min);
        Random random = new Random();
        int big = random.nextInt(number);  // 4倍暴击概率
        for (int i = 0; i < thb.length - 1; i++) {  // 随机分配前n-1个红包
            if(t_total==0){  // 已全部分配
                break;
            }
            int rd;
            int t_num = number - i;  // 当前剩余需分配红包个数
            if(i == big && t_num >= 4){
                // 暴击最高金额：(可分配总金额/剩余需分配红包个数)*4
                rd = random.nextInt(t_total / t_num * 4);
            }else{
                // 最高金额：(可分配总金额/剩余需分配红包个数)*2
                rd = random.nextInt(t_total / t_num * 2);
            }
            t_total -= rd;
            thb[i] += rd;
        }
        thb[number-1] += t_total;  // 最后剩余金额给最后一个红包

        // 最终缩小回原始倍数后的每个红包数
        double[] hb = new double[number];
        for (int i = 0; i < number; i++) {
            hb[i] = thb[i]/(beiShu*1.0);
        }
        return hb;
    }

}
