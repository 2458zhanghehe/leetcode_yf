package com.company.Bishi.meituan.day0330;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();

        int len = s.length();
        while(s.charAt(len - 1) == t.charAt(len - 1)){
            len--;
            if(len == 0){
                System.out.println(0);
                return;
            }
        }
        s = s.substring(0,len);
        t = t.substring(0,len);

        //第key段，到val位置终止
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        int nums1 = Fenduan(map1, s);
        int nums2 = Fenduan(map2, t);

        int ans = 0;
        Queue<Info> ansQueue = new LinkedList<>();
        if(nums1 < nums2){
            for(int i = nums1 - 1; i >= 0; i--){
                Integer r = map1.get(i);
                Integer l = 0;
                if(i - 1 >= 0){
                    l = map1.get(i - 1);
                    l++;
                }
                if(s.substring(l,r + 1).equals(t.substring(l, r + 1))){
                    continue;
                }
                ans++;
                ansQueue.add(new Info(r + 1, s.charAt(r)));
            }
            System.out.println(ans);
            while(!ansQueue.isEmpty()){
                Info info = ansQueue.poll();
                System.out.println(2 + " " + info.r + " " + info.c);
            }
        }else {
            for(int i = nums2 - 1; i >= 0; i--){
                Integer r = map2.get(i);
                Integer l = 0;
                if(i - 1 >= 0){
                    l = map2.get(i - 1);
                    l++;
                }
                if(s.substring(l,r + 1).equals(t.substring(l, r + 1))){
                    continue;
                }
                ans++;
                ansQueue.add(new Info(r + 1, t.charAt(r)));
            }
            System.out.println(ans);
            while(!ansQueue.isEmpty()){
                Info info = ansQueue.poll();
                System.out.println(1 + " " + info.r + " " + info.c);
            }
        }
    }

    private static int Fenduan(HashMap<Integer,Integer> map, String str){
        int len = str.length();
        int nums = 0;
        for(int i = 0; i < len; i++){
            while(i + 1 < len && str.charAt(i) == str.charAt(i + 1)){
                i++;
            }
            map.put(nums,i);
            nums++;
        }
        return nums;
    }

    private static class Info{
        int r;
        char c;
        public Info(int r, char c){
            this.r = r;
            this.c = c;
        }
    }
}
