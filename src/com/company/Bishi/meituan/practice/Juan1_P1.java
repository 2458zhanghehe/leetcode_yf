package com.company.Bishi.meituan.practice;

import java.util.Scanner;

public class Juan1_P1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        double sum = 0;
        double sum_chept = 0;
        int n = in.nextInt();
        while (n > 0) { // 注意 while 处理多个 case
            double a = in.nextDouble();
            double b = in.nextDouble();
            if(a < b || a <=0 || b <= 0){
                System.out.println("error");
                return;
            }
            sum += a;
            sum_chept += b;
            n--;
        }
        double man = in.nextDouble();
        double cheap = in.nextDouble();
        if(man < cheap || man <=0 || cheap <= 0){
            System.out.println("error");
            return;
        }
        if(sum >= man){
            sum -= cheap;
        }
        double min = Math.min(sum, sum_chept);
        System.out.printf("%.02f", min);
    }
}
