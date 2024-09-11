package com.company.Shousi.proxy.jdk;

public class BigStarJdk implements Star {

    public String name;

    public BigStarJdk(String name){
        this.name = name;
    }

    @Override
    public final void sing(String musicName){
        System.out.println(this.name + "正在唱" + musicName);
    }

    @Override
    public String dance(){
        System.out.println(this.name + "正在跳");
        return "太酷啦";
    }

}
