package com.company.Bishi.xiecheng.Day0919;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        Collections.sort(list);
        int index = 1;
        while(n > m && index < list.size()){
            while(index < list.size() && list.get(index) - list.get(index - 1) <= k && n > m){
                n--;
                list.remove(index - 1);
            }
            index++;
        }
        System.out.println(n);
    }
}
