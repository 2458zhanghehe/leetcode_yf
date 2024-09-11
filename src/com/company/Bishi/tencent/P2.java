package com.company.Bishi.tencent;

public class P2 {
    public static int sumOfString(String str1, String str2){
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        int ans = 0;
        int Jin = 1;
        int p1 = chars1.length - 1;
        int p2 = chars2.length - 1;
        while(p1 >= 0 && p2 >= 0){
            //char - 48 可以直接写成 char - '0' 就不用找48了
            int curSum = (chars1[p1--] - 48 + chars2[p2--] - 48) * Jin;
            ans += curSum;
            Jin *= 10;
        }
        while(p1 >= 0){
            ans += (chars1[p1--] - 48)*Jin;
            Jin *= 10;
        }
        while(p2 >= 0){
            ans += (chars2[p2--] - 48)*Jin;
            Jin *= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        String str1 = "1";
        String str2 = "999";
        int ans = sumOfString(str1, str2);
        System.out.println(ans);
    }
}
