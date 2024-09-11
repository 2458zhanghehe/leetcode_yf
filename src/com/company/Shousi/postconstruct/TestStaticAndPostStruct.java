package com.company.Shousi.postconstruct;

import javax.annotation.PostConstruct;

public class TestStaticAndPostStruct {

    private static int a;
    private int b;

    public TestStaticAndPostStruct(){

    }

    static {
        a = 100;
        System.out.println("static代码块执行了");
    }

    //好像必须springboot加载servlet之后执行
    @PostConstruct
    public void initTest(){
        b = 10;
        System.out.println("postConstruct初始化执行了");
    }
}
