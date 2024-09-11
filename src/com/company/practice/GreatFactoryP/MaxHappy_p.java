package com.company.practice.GreatFactoryP;

import java.util.List;

//树形dp，递归套路
public class MaxHappy_p {
    public static class Employee {
        public int happy;
        public List<Employee> nexts;
    }

    public static class Info {
        public int lai;
        public int buLai;

        public Info(int l, int b) {
            lai = l;
            buLai = b;
        }
    }

    public static int MH(Employee boss) {
        Info bossI = process(boss);
        return Math.max(bossI.lai, bossI.buLai);
    }

    public static Info process(Employee e) {
        if (e.nexts == null) {
            return new Info(e.happy, 0);
        }
        int l = e.happy;
        int b = 0;
        for (Employee tmp : e.nexts) {
            Info tmpI = process(tmp);
            l += tmpI.buLai;
            b += Math.max(tmpI.lai, tmpI.buLai);
        }
        return new Info(l, b);
    }
}
