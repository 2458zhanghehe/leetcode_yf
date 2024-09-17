package com.company.Bishi.vivo;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        Integer a = 1;
        map.remove(a);
        System.out.println(map.isEmpty());
    }
}
