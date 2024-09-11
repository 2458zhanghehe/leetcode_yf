package com.company.GreatFactoryProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

//leetcode 202
public class HappyNum {
    public static boolean isHappy(int n) {
        //val, index
        HashMap<Integer, Integer> map = new HashMap<>();

        int index = 0;
        map.put(n,index);
        while(true){
            int sum = 0;
            while(n >= 10){
                int a = n % 10;
                sum += a*a;
                n = n / 10;
            }
            sum += n*n;
            n = sum;
            if(n == 1){
                return true;
            }
            if(map.containsKey(n)){
                break;
            }
            map.put(n,++index);
        }
        return false;
    }

    public static void main(String[] args) {
        boolean happy = isHappy(2);
        System.out.println(happy);


        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Integer num = 10;
//        if(!hashMap.containsKey(num)){
//            hashMap.put(num,1);
//        }else {
//            hashMap.put(num,hashMap.get(num) + 1);
//        }
        //等价于
        hashMap.put(num,hashMap.getOrDefault(num,0) + 1);
    }
}
