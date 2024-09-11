package com.company.Shousi.proxy.myProxyJdk;


public class Target implements FooAndBar{
    @Override
    public void foo() {
        System.out.println("foo");
    }

    @Override
    public int bar(String name) {
        System.out.println(name + "正在执行bar");
        return 100;
    }
}
