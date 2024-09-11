package com.company.Bishi.Huawei.practice;

import java.util.*;

public class P2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String[] split = s.split(" ");

        Arrays.sort(split, (o1, o2) -> o1.length() - o2.length());

        HashSet<String> set = new HashSet<>();

        ArrayList<String> ans = new ArrayList<>();

        for(int i = 0; i < split.length; i++){
            String cur = split[i];
            if(cur.length() == 1){
                ans.add(cur);
            }else {
                String help = cur.substring(0, cur.length() - 1);
                while(!"".equals(help) && set.contains(help)){
                    help = help.substring(0,help.length() - 1);
                }
                if("".equals(help)){
                    ans.add(cur);
                }
            }
            set.add(cur);
        }
        Collections.sort(ans);
        System.out.println(ans.get(ans.size() - 1));
    }
}
