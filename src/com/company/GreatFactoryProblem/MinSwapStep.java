package com.company.GreatFactoryProblem;


// 一个数组中只有两种字符'G'和'B'，
// 可以让所有的G都放在左侧，所有的B都放在右侧
// 或者可以让所有的G都放在右侧，所有的B都放在左侧
// 但是只能在相邻字符之间进行交换操作，请问请问至少需要交换几次，
public class MinSwapStep {
    public static int MSS(String s) {
        return Math.min(process(s, 'G'), process(s, 'B'));
    }

    public static int process(String s, char leftchar) {
        int ans = 0;
        for (int L = 0, index = 0; index < s.length(); index++) {
            if (s.charAt(index) == leftchar) {
                ans += index - L;
                L++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "GGBGGGBB";
        System.out.println(MSS(s));
    }
}
