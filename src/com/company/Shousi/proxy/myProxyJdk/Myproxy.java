package com.company.Shousi.proxy.myProxyJdk;

import java.lang.reflect.Method;

public class Myproxy implements FooAndBar{

    private static Method foo;
    private static Method bar;

    static {
        try {
            foo = Target.class.getMethod("foo");
            bar = Target.class.getMethod("bar", String.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private MyInvocationHandler handler;

    //jdk的实现其实是代理类继承Proxy，然后直接super(handler)传递给父构造, 直接使用InvocationHandler而不是自己实现
    public Myproxy(MyInvocationHandler handler){
        this.handler = handler;
    }

    @Override
    public void foo() {
        try {
            handler.invoke(foo, new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int bar(String name) {
        try {
            Object[] args = new Object[1];
            args[0] = name;
            Object result = handler.invoke(bar, args);
            return (int)result;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
