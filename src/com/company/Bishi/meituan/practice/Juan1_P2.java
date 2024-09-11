package com.company.Bishi.meituan.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Juan1_P2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();   //注意一定要有，不然s会读到空 将输入流中的换行符消耗掉，因为nextInt不会读取换行符
        String s = sc.nextLine();   //直接读取一行，换行符也会读到
        String t = sc.nextLine();

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        if(sChars.length != n || tChars.length != n){
            System.out.println("error");
            return;
        }
        HashMap<Character, List<Character>> map = new HashMap<>();
        int ans = 0;
        boolean flag = true;
        for(int i = 0; i < n; i++){
            if(sChars[i] == tChars[i]){
                ans++;
            }else if(flag){
                if(map.containsKey(tChars[i])){
                    List<Character> chars = map.get(tChars[i]);
                    if(chars.contains(sChars[i])){
                        flag = false;
                        ans += 2;
                        continue;
                    }
                }
                List<Character> chars = null;
                if(map.containsKey(sChars[i])){
                    chars = map.get(sChars[i]);
                }else {
                    chars = new ArrayList<>();
                }
                chars.add(tChars[i]);
                map.put(sChars[i],chars);
            }
        }
        System.out.println(ans);
    }
}
