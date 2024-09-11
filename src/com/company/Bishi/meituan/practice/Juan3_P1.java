package com.company.Bishi.meituan.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Juan3_P1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        long s = 0;
        int ans = -1;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 0);
        // 注意 hasNext 和 hasNextLine 的区别
        for (int i = 1; i <= n; i++) { // 注意 while 处理多个 case
            s += in.nextInt() - k;
            if(!map.containsKey(s)) map.put(s, i);
            else ans = Math.max(ans, i - map.get(s));
        }
        System.out.println(ans);
    }
}
