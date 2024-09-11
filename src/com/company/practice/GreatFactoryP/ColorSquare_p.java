package com.company.practice.GreatFactoryP;

public class ColorSquare_p {
    //square[i] = 1 2分别代表红色绿色
    public static int colorSquare(int[] squares) {
        int N = squares.length;
        int[] Green = new int[N]; //0到i位置绿色个数
        int[] Red = new int[N];  //i到N-1位置红色个数
        Green[0] = squares[0] == 2 ? 1 : 0;
        for (int i = 1; i < N; i++) {
            Green[i] = squares[i] == 2 ? (Green[i - 1] + 1) : Green[i - 1];
        }
        Red[N - 1] = squares[N - 1] == 1 ? 1 : 0;
        for (int i = N - 2; i >= 0; i--) {
            Red[i] = squares[i] == 1 ? (Red[i + 1] + 1) : Red[i + 1];
        }
        int ans = Integer.MAX_VALUE;
        for (int L = 0; L <= N; L++) {  //0-L-1为红色 L到N-1位绿色
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
        int[] square = {1, 2, 1, 1, 2, 2, 1};
        System.out.println(colorSquare(square));
    }
}
