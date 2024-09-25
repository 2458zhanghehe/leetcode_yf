package com.company.Shousi.GoF23.proxy.myProxyJdk;

import java.lang.reflect.Method;

public interface MyInvocationHandler {
    Object invoke(Method method, Object[] args) throws Throwable;
}
