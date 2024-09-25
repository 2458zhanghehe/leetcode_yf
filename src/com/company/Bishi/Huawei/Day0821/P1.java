package com.company.Bishi.Huawei.Day0821;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//数据重删
public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        //保证顺序不变
        ArrayList<String> keys = new ArrayList<>();

        int i = 0;
        while(i < n){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < k && i < n; j++) {
                int cur = sc.nextInt();
                sb.append(cur);
                sb.append(" ");
                i++;
            }
            String cur = sb.toString();
            if(map.containsKey(cur)){
                map.put(cur, map.get(cur) + 1);
            }else {
                map.put(cur, 1);
                keys.add(cur);
            }
        }
        for(String key : keys){
            Integer count = map.get(key);
            System.out.print(key + count + " ");
        }
    }
}
