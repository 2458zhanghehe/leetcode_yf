package com.company.Queue;

import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>();
        Integer a = new Integer(1);
        Integer b = new Integer(1);
        //包装类重写了hascode和equals方法，即使a和b是引用不同的对象也不能加入同一set
        //int[]就没重写
        set1.add(a);
        set1.add(b);

        HashSet<int[]> set2 = new HashSet<>();
        int[] c = new int[]{1,2};
        int[] d = new int[]{1,2};
        set2.add(c);
        set2.add(d);

        //set1大小为1，set2大小为2
    }
}
