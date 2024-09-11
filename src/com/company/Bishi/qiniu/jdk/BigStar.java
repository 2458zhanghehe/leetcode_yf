package com.company.Bishi.qiniu.jdk;

public class BigStar implements Star{
    private String name;

    public BigStar(String name){
        this.name = name;
    }

    @Override
    public void sing(String musicName) {
        System.out.println(name + "正在唱：" + musicName);
    }

    @Override
    public String dance() {
        System.out.println(name + "正在跳");
        return "谢谢";
    }
}
