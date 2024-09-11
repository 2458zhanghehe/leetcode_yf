package com.company.GreatFactoryProblem;

public class ColorSquare {
    //s[i]为第i个正方形，其中1代表红色，2代表绿色
    public static int colorSquare1(int[] s) {
        int N = s.length;
        int ans = Integer.MAX_VALUE;
        for (int L = 0; L <= N; L++) {   //0到L - 1全部为红色， L到N-1全部为绿色
            if (L == 0) {
                int sumR = 0;
                for (int i = 0; i < N; i++) {
                    if (s[i] == 1) {
                        sumR++;
                    }
                }
                ans = Math.min(ans, sumR);
            } else if (L == N) {
                int sumG = 0;
                for (int i = 0; i < N; i++) {
                    if (s[i] == 2) {
                        sumG++;
                    }
                }
                ans = Math.min(ans, sumG);
            } else {
                int sumR = 0;
                int sumG = 0;
                for (int i = 0; i < N; i++) {
                    if (i <= L) {
                        if (s[i] == 2) {
                            sumG++;
                        }
                    } else {
                        if (s[i] == 1) {
                            sumR++;
                        }
                    }
                }
                ans = Math.min(ans, sumR + sumG);
            }
        }
        return ans;
    }

    //预处理两张表 时间复杂度O(n^2) --> O(3*n) 空间换时间
    public static int colorSquare2(int[] s) {
        int N = s.length;
        int ans = Integer.MAX_VALUE;
        int[] Green = new int[N];  // 0到i位置上绿方块个数
        Green[0] = s[0] == 2 ? 1 : 0;
        for (int i = 1; i < N; i++) {
            Green[i] = s[i] == 2 ? (Green[i - 1] + 1) : Green[i - 1];
        }
        int[] Red = new int[N];   // i到n-1位置上红方块个数
        Red[N - 1] = s[N - 1] == 1 ? 1 : 0;
        for (int i = N - 2; i >= 0; i--) {
            Red[i] = s[i] == 1 ? (Red[i + 1] + 1) : Red[i + 1];
        }

        for (int L = 0; L <= N; L++) {  //0到L-1为红 L到N-1为绿
            if (L == 0) {
                ans = Math.min(ans, Red[0]);
            } else if (L == N) {
                ans = Math.min(ans, Green[N - 1]);
            } else {
                ans = Math.min(ans, Green[L - 1] + Red[L]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] s = new int[]{1, 2, 1, 2, 2, 1};
        System.out.println(colorSquare1(s));
        System.out.println(colorSquare2(s));
    }
}
