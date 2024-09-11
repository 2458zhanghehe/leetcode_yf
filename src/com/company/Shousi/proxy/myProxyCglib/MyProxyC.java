package com.company.Shousi.proxy.myProxyCglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


//整体框架和jdk差不多，不过methodProxy的创建比较麻烦
public class MyProxyC extends TargetC{

    private MethodInterceptor methodInterceptor;

    public void setMethodInterceptor(MethodInterceptor methodInterceptor){
        this.methodInterceptor = methodInterceptor;
    }

    static Method t1;
    static Method t2;
    static Method t3;
    static MethodProxy t1Proxy;
    static MethodProxy t2Proxy;
    static MethodProxy t3Proxy;

    static {
        try {
            t1 = TargetC.class.getDeclaredMethod("t");
            t2 = TargetC.class.getDeclaredMethod("t", int.class);
            t3 = TargetC.class.getDeclaredMethod("t", int.class, int.class);
                                   //目标类、代理类、java字节码的方法参数和返回值描述符、带增强功能的方法、不带增强功能的方法
                                   //()V表示无参无返回值 (I)V表示一个int参，无返回值
            t1Proxy = MethodProxy.create(TargetC.class, Proxy.class, "()V", "t", "tSuper");
            t2Proxy = MethodProxy.create(TargetC.class, Proxy.class, "(I)V", "t", "tSuper");
            t3Proxy = MethodProxy.create(TargetC.class, Proxy.class, "(II)Ljava/lang/String;", "t", "tSuper");

        } catch (NoSuchMethodException e) {
            throw new NoSuchMethodError(e.getMessage());
        }
    }

    public void tSuper(){
        super.t();
    }

    public void tSuper(int i){
        super.t(i);
    }

    public String tSuper(int i, int j){
        return super.t(i,j);
    }

    @Override
    public void t() {
        try {
            //methodInterceptor.intercept(this, t1, new Object[0], null);
            methodInterceptor.intercept(this, t1, new Object[0], t1Proxy);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void t(int i) {
        try {
            methodInterceptor.intercept(this, t2, new Object[]{i}, t2Proxy);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String t(int i, int j) {
        try {
            Object result = methodInterceptor.intercept(this, t3, new Object[]{i, j}, t3Proxy);
            return (String) result;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
