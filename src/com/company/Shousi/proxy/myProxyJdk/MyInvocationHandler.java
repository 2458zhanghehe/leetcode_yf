package com.company.Shousi.proxy.myProxyJdk;

import java.lang.reflect.Method;

public interface MyInvocationHandler {
    Object invoke(Method method, Object[] args) throws Throwable;
}
