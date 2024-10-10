package com.company.Bishi.ant.Day0929;

import java.util.ArrayList;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> prices = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            prices.add(sc.nextInt());
        }

        int sum = 0;
        for (int k = 0; k < 2; k++) {
            int lowPrice = Integer.MAX_VALUE;
            int buyIndex = -1;
            for (int i = 0; i < prices.size(); i++) {
                if(prices.get(i) < lowPrice){
                    lowPrice = prices.get(i);
                    buyIndex = i;
                }
                if(i == prices.size() - 1 || prices.get(i) > prices.get(i + 1)){
                    int delta = prices.get(i) - lowPrice;
                    if(delta > 0){
                        sum += delta;
                        prices.remove(buyIndex);
                        prices.remove(i - 1);
                        i -= 2;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
