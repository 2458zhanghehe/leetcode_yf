package com.company.practice.GreatFactoryP;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;
import org.omg.CORBA.MARSHAL;

public class Pow_p {
    public static double pow_p(double x, int n) {
        if (n == 0) {
            return 1D;
        }
        int pow = Math.abs((n == Integer.MIN_VALUE) ? n + 1 : n);
        double ans = 1D;
        double t = x;
        while (pow != 0) {
            if ((pow & 1) != 0) {
                ans *= t;
            }
            pow = pow >> 1;
            t *= t;
        }
        if (n == Integer.MIN_VALUE) {
            ans *= x;
        }
        if (n < 0) {
            ans = 1D / ans;
        }
        return ans;
    }
}
