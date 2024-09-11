package com.company.Bishi.qiniu.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyProxy implements Star{

    private static Method sing;
    private static Method dance;

    static {
        try {
            sing = BigStar.class.getMethod("sing", String.class);
            dance = BigStar.class.getMethod("dance");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private InvocationHandler invocationHandler;
    public MyProxy(InvocationHandler invocationHandler){
        this.invocationHandler = invocationHandler;
    }

    @Override
    public void sing(String musicName) {

        try {
            invocationHandler.invoke(this, sing, new Object[]{musicName});
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String dance() {
        try {
            Object result = invocationHandler.invoke(this, dance, new Object[0]);
            return (String) result;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
