package com.company.Bishi.Y4399;

import java.util.ArrayList;
import java.util.List;

public class RandomGetNotRepeat {

    private List<Integer> list;
    public RandomGetNotRepeat(){
        list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            list.add(i);
        }
    }

    public int randomGetNotRepeat(){
        int index = (int) (list.size() * Math.random());
        return list.remove(index);
    }

    public static void main(String[] args) {
        RandomGetNotRepeat randomGetNotRepeat = new RandomGetNotRepeat();
        for (int i = 0; i < 100; i++) {
            System.out.println(randomGetNotRepeat.randomGetNotRepeat());
        }
    }
}
