package com.company.Bishi.ant.Day0316;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arrA = new int[n];
        int sum = 0;
        boolean allOuShu = true;
        for (int i = 0; i < n; i++) {
            arrA[i] = sc.nextInt();
            sum += arrA[i];
            if((arrA[i] & 1) == 1){
                allOuShu = false;
            }
        }
        if(allOuShu){
            System.out.println("YES");
            System.out.println(2);
            return;
        }

        int avg = sum / n;
        List<Integer> list = get_divisors(avg, sum);
        //去重加排序
        list = list.stream().distinct().sorted().collect(Collectors.toList());

        ArrayList<Integer> ansList = new ArrayList<>();
        for(Integer cur : list){
            if(cur < 3){
                continue;
            }
            int curSum = 0;
            for(int i = 0; i < n; i++){
                if((arrA[i] & 1) == 1){
                    curSum += cur;
                }else {
                    curSum += 2 * cur;
                }
            }
            if(curSum < sum){
                ansList.add(cur);
            }
        }

        if(ansList.size() == 0){
            System.out.println("NO");
        }else {
            System.out.println("YES");
            for(Integer cur : ansList){
                System.out.print(cur + " ");
            }
        }
    }

    //找到小于等于avg的所有质数因子
    private static List<Integer> get_divisors(int avg, int sum) {
        int k = (int) Math.sqrt(sum);
        int min = Math.min(k, avg);
        List<Integer> res = new ArrayList<>();
        for (int i = 2; i <= min; i++) {
            while(sum != i) {
                if (sum % i == 0) {
                    res.add(i);
                    sum = sum / i;
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
