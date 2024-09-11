package com.company.Shousi.WriteHashMap;

public class Test {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("China","KuaiZi");
        myHashMap.put("UK","ChaiZi");
        myHashMap.put("India","RightHand");
        myHashMap.put("India","LeftHand");

        System.out.println(myHashMap.size());
        System.out.println(myHashMap.get("India"));

    }
}
