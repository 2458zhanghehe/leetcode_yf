package com.company.array;

import java.util.PriorityQueue;

import static com.company.sort.Code02_BubbleSort.swap;

public class Test {
    public static void main(String[] args) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        if((long)(max - min) <= 1){
            System.out.println("error");
        }else {
            System.out.println("correct");
        }
    }
}
