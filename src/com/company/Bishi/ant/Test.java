package com.company.Bishi.ant;

public class Test {
    /*小红定义一个字符串的权值是：字符串辅音数量和元音数量的差的绝对值。
    例如，"arcaea"的权值是 2，因为有 4 个元音，2 个辅音，权值为|4-2|=2。
    现在小红拿到了一个字符串，她想把这个字符串切成两个非空字符串，需要满足两
    个字符串的权值相等。小红想知道，有多少种不同的切割方式？我们定义，元音有
    "aeiou"这五种，其余字母均为辅音。
    * */
    public static void main(String[] args) {
        String s = "arcaeafs";
        int n = s.length();
        int[] pre = new int[n + 1];
        int[] suf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + (s.charAt(i - 1) == 'a' || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'i' || s.charAt(i - 1) == 'o' || s.charAt(i - 1) == 'u' ? 1 : -1);
        }
        for (int i = n - 1; i >= 0; i--) {
            suf[i] = suf[i + 1] + (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' ? 1 : -1);
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (pre[i] == suf[i]) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
