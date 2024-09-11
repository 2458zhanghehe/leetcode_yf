package com.company.Shousi.GoF23.singleton;

//饿汉式单例模式
public class HungryMan {

    //单列模式一定私有构造器，防止其他人new
    private HungryMan(){

    }

    private static final HungryMan HUNGRY_MAN = new HungryMan();

    public static HungryMan getInstance(){
        return HUNGRY_MAN;
    }
}
