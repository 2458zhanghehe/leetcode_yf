package com.company.Bishi.ant;



import java.util.Scanner;
import java.util.concurrent.Future;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] prices = new int[n];
        for(int i = 0; i < n; i++){
            prices[i] = sc.nextInt();
        }
        boolean[] is95 = new boolean[n];
        sc.nextLine();
        String s = sc.nextLine();
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '1'){
                is95[i] = true;
            }else {
                is95[i] = false;
            }
        }
        int nums = process(prices, (double) k,0,is95);
        System.out.println(nums);
    }

    private static int process(int[] prices, Double cur, int index, boolean[] is95) {
        if(cur <= 0){
            return 0;
        }
        if(index >= prices.length){
            return 0;
        }
        return Math.max(process(prices,cur - prices[index] * (is95[index] ? 0.95 : 1.0),index + 1,is95) + 1,
                process(prices,cur,index + 1,is95));
    }
}
