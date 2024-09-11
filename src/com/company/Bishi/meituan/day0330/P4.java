package com.company.Bishi.meituan.day0330;



import java.util.*;

public class P4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();

        int ans = 0;
        for(int i = 2; i <= n; i += 2){
            //key num
            HashMap<Character, Integer> map = new HashMap<>();
            int curAns = process(str,i, 0, "");
            ans += curAns;
        }
        System.out.println(ans);
    }

    private static int process(String str, int len, int index, String curStr){
        if(len == curStr.length()){
            HashMap<Character, Integer> map = new HashMap<>();
            for(int i = 0; i < curStr.length(); i++){
                if(map.containsKey(curStr.charAt(i))){
                    Integer nums = map.get(curStr.charAt(i));
                    map.put(curStr.charAt(i),nums + 1);
                }else {
                    map.put(curStr.charAt(i), 1);
                }
            }
            if(map.size() == 2){
                int num = -1;
                for(Map.Entry<Character,Integer> entry : map.entrySet()){
                    if(num == -1){
                        num = entry.getValue();
                    }else {
                        return num == entry.getValue() ? 1 : 0;
                    }
                }

            }else {
                return 0;
            }
        }

        if(index >= str.length()){
            return 0;
        }
        //不要
        int num1 = process(str, len, index + 1, curStr);
        //要
        int num2 = process(str,len,index + 1,curStr + str.charAt(index));
        return num1 + num2;

    }
}
