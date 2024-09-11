package com.company.string;

//leetcode 5 最长回文子串
// 马拉车算法  最重要的是回文长度数组的维护，后面还会用到这个思想
public class Manacher {
    public static int mancher(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        char[] sChar = s.toCharArray();
        char[] sCharTwo = getdouble(sChar);
        int[] p_arr = new int[sCharTwo.length];  // p_arr存储的是右部分长度+中心点 回文半径
        int R = -1;  //R代表最右边界的下一个位置
        int c = -1;
        int maxLen = 0;
        for (int i = 0; i < sCharTwo.length; i++) {
            p_arr[i] = R > i ? Math.min(p_arr[2 * c - i], R - i) : 1;
            while (i + p_arr[i] < sCharTwo.length && i - p_arr[i] > -1) {
                if (sCharTwo[i + p_arr[i]] == sCharTwo[i - p_arr[i]]) {
                    p_arr[i]++;
                } else {
                    break;
                }
            }
            if (p_arr[i] + i > R) {
                R = p_arr[i] + i;
                c = i;
            }
            maxLen = Math.max(maxLen, p_arr[i]);
        }
        return maxLen - 1;    //加上#扩展后，实际回文直径等于扩展后回文半径-1；
    }


    public static char[] getdouble(char[] str) {
        char[] res = new char[2 * str.length + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) != 0 ? str[(i - 1) / 2] : '#';
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abc12320de1";
//        System.out.print(getdouble(s));
        System.out.println(mancher(s));
    }
}
