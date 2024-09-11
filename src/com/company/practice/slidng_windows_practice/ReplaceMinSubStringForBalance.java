package com.company.practice.slidng_windows_practice;

public class ReplaceMinSubStringForBalance {
    public static int RMSSFB(String s) {
        int[] s_int = new int[s.length()];
        int[] cnts = new int[4];
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            s_int[i] = tmp == 'W' ? 1 : (tmp == 'E' ? 2 : (tmp == 'R' ? 3 : 0));
            cnts[s_int[i]]++;
        }
        int ans = Integer.MAX_VALUE;
        if (cnts[0] == s.length() / 4 && cnts[1] == s.length() / 4 || cnts[2] == s.length() / 4) {
            return 0;
        }
        for (int l = 0, r = 0, require = s.length() / 4; r < s.length(); r++) {
            cnts[s_int[r]]--;
            while (isOK(cnts, require)) {
                ans = Math.min(ans, r - l + 1);
                cnts[s_int[l]]++;
                if (!isOK(cnts, require)) {
                    cnts[s_int[l]]--;
                    break;
                }
                l++;
            }
        }
        return ans;
    }

    public static boolean isOK(int[] cnts, int require) {
        for (int i = 0; i < cnts.length; i++) {
            if (cnts[i] > require) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "QWER";
        System.out.print(RMSSFB(s));
    }
}
