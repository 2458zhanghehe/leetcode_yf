package com.company.Shousi.reflact;

public class Person {
    public String name;
    private int age;

    public Person(){
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void run(String str){
        System.out.println(str + "running");
    }

    private void jump(int a){
        System.out.println(a + "jumping");
    }
}
