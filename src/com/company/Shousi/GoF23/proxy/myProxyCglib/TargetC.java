package com.company.Shousi.GoF23.proxy.myProxyCglib;

public class TargetC {

    public void t(){
        System.out.println("t1无参方法");
    }

    public void t(int i){
        System.out.println("t1方法: " + i);
    }

    public String t(int i, int j){
        System.out.println("t3方法: " + i + ", " + j);
        return "t3执行完毕";
    }
}
