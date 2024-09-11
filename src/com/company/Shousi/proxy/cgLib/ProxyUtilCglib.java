package com.company.Shousi.proxy.cgLib;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class ProxyUtilCglib {

    public BigStarCglib createProxyIns(BigStarCglib starCglib){
        BigStarCglib proxy = (BigStarCglib) Enhancer.create(BigStarCglib.class, new MethodInterceptor() {
            //MethodInterceptor是callback实现类之一
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                if ("sing".equals(method.getName())) {
                    System.out.println("准备话筒");
                } else if ("dance".equals(method.getName())) {
                    System.out.println("准备场地");
                }
                //Object result = method.invoke(starCglib, args);  //使用反射的方法调用目标
                Object result = methodProxy.invoke(starCglib, args);  //不使用反射调用  springAop实现使用的是这个
                //System.out.println("后置增强");
                return result;
            }
        });

        return proxy;
    }
}
