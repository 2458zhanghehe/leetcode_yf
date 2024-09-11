package com.company.Bishi.pinduoduo;

import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(--t >= 0){
            String str = sc.nextLine();

            int[] cnts = new int[26];
            for(int i = 0; i < str.length(); i++){
                cnts[str.charAt(i) - 97]++;
            }

            int ans = 0;
            while(!"".equals(str)){
                int[] range = processManacher(str);
                StringBuilder sb = new StringBuilder();
                if(range[0] == range[1]){
                    int delIndex = range[0];
                    for(int i = 0; i < str.length(); i++){
                        if(cnts[str.charAt(i) - 97] == 1){
                            delIndex = i;
                            break;
                        }
                    }
                    cnts[str.charAt(delIndex) - 97] = 0;
                    sb.append(str, 0, delIndex);
                    sb.append(str,delIndex + 1,str.length());
                    str = sb.toString();
                }else {
                    for(int j = range[0]; j <= range[1]; j++){
                        cnts[str.charAt(j) - 97] = 0;
                    }
                    sb.append(str, 0, range[0]);
                    sb.append(str,range[1] + 1,str.length());
                    str = sb.toString();
                }
                ans++;
            }
            System.out.println(ans);
        }
    }

    private static int[] process(String str) {
        char[] res = getDouble(str.toCharArray());
        int maxLen = 0;
        int L = 0;
        int R = 0;

        for(int i = 0; i < res.length; i++){
            int t = 1;
            while((i - t) >= 0 && (i + t) < res.length && res[i - t] == res[i + t]){
                if(2 * t + 1 > maxLen){
                    maxLen = 2 * t + 1;
                    L = i - t;
                    R = i + t;

                }
                t++;
            }
        }
        return new int[]{L / 2,(R - 1) / 2};
    }

    private static int[] processManacher(String str) {
        char[] sChar = str.toCharArray();
        char[] sCharTwo = getDouble(sChar);
        int[] p_arr = new int[sCharTwo.length];
        int R = -1;
        int c = -1;
        int maxLen = 0;
        int mL = 0;
        int mR = 0;

        for(int i = 0; i < sCharTwo.length; i++){
            p_arr[i] = R > i ? Math.min(p_arr[2 * c - i],R - i) : 1;
            while(i - p_arr[i] >= 0 && i + p_arr[i] < sCharTwo.length){
                if(sCharTwo[i - p_arr[i]] == sCharTwo[i + p_arr[i]]){
                    p_arr[i]++;
                }else {
                    break;
                }
            }

            if(p_arr[i] + i > R){
                c = i;
                R = p_arr[i] + i;
            }

            if(p_arr[i] > maxLen){
                maxLen = p_arr[i];
                mL = i - p_arr[i] + 1;
                mR = i + p_arr[i] - 1;
            }

        }
        return new int[]{mL / 2, (mR - 1) / 2};
    }

    private static char[] getDouble(char[] str) {
        char[] res = new char[2 * str.length + 1];
        for(int i = 0; i < res.length; i++){
            res[i] = (i & 1) != 0 ? str[(i - 1) / 2] : '#';
        }
        return res;
    }
}
