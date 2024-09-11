package com.company.slidingW;

//左 39
public class ReplaceTheMInSubStringForBalance {
    public static int rtmsfb(String s) {
        int s_length = s.length();
        int[] s_int = new int[s_length];
        int[] cnts = new int[4];
        for (int i = 0; i < s_length; i++) {
            char tmp = s.charAt(i);
            s_int[i] = tmp == 'W' ? 1 : (tmp == 'E' ? 2 : (tmp == 'R' ? 3 : 0));
            cnts[s_int[i]]++;
        }
        int require = s.length() / 4;
        int ans = Integer.MAX_VALUE;

        for (int L = 0, R = 0; L < s_length; L++) {
            while (!isOk(cnts, require) && R < s_length) {
                cnts[s_int[R++]]--;
            }
            if (isOk(cnts, require)) {
                ans = Math.min(ans, R - L);
            }
            cnts[s_int[L]]++;
        }
        return ans;
    }

    public static boolean isOk(int[] cnts, int requre) {
        for (int i = 0; i < cnts.length; i++) {
            if (cnts[i] > requre) {
                return false;
            }
        }
        return true;
    }
}
