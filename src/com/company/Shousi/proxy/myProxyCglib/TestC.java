package com.company.Shousi.proxy.myProxyCglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TestC {
    public static void main(String[] args) {
        MyProxyC myProxyC = new MyProxyC();

        TargetC targetC = new TargetC();
        myProxyC.setMethodInterceptor(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("before....");
                //Object result = method.invoke(targetC, args);  //用反射实现
                Object result = methodProxy.invoke(targetC, args); //不用反射实现，
                //Object result = methodProxy.invokeSuper(proxy, args);  //不用反射实现
                System.out.println("after......................................");
                return result;
            }
        });

        myProxyC.t();
        myProxyC.t(1);
        String ans = myProxyC.t(3, 4);
        System.out.println(ans);
    }
}
