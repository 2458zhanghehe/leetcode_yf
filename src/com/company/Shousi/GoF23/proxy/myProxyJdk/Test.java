package com.company.Shousi.GoF23.proxy.myProxyJdk;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) {

        FooAndBar proxy = new Myproxy(new MyInvocationHandler(){
            @Override
            public Object invoke(Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
                System.out.println("before");
                Object result = method.invoke(new Target(), args);
                return result;
            }
        });

        proxy.foo();
        int ans = proxy.bar("ikun");
        System.out.println(ans);
    }
}
