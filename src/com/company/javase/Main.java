package com.company.javase;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Student student = new Student();
        student.methodS();
        student.method1();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list.get(1));
    }
}
