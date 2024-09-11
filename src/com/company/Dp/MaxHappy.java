package com.company.Dp;

import java.util.List;

//树形dp，递归套路
public class MaxHappy {
    public static class Employee {
        public int happy;
        public List<Employee> nexts;
    }

    public static int maxHappy(Employee boss) {
        Info bossInfo = process(boss);
        return Math.max(bossInfo.buHappy, bossInfo.laiHappy);
    }

    public static class Info {
        public int laiHappy;
        public int buHappy;

        public Info(int l, int b) {
            laiHappy = l;
            buHappy = b;
        }
    }

    public static Info process(Employee employee) {
        if (employee.nexts == null) {
            return new Info(employee.happy, 0);
        }
        int lai = employee.happy;
        int bulai = 0;
        for (Employee tmp : employee.nexts) {
            Info tmpinfo = process(tmp);
            lai += tmpinfo.laiHappy;
            bulai += Math.max(tmpinfo.buHappy, tmpinfo.laiHappy);
        }
        return new Info(lai, bulai);
    }


}
