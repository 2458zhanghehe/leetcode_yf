package com.company.Shousi.GoF23.proxy.cgLib;


public class BigStarCglib {

    public String name;
    public BigStarCglib(){
        this.name = "默认胡汉三";
    }

    public BigStarCglib(String name){
        this.name = name;
    }


    public void sing(String musicName){
        System.out.println(this.name + "正在唱" + musicName);
    }


    public String dance(){
        System.out.println(this.name + "正在跳");
        return "太酷啦";
    }

}
