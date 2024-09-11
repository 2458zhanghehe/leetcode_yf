package com.company.Shousi.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class ProxyUtilJdk {

    public static Star createProxy(BigStarJdk bigStarJdk){
        /*
        * newProxyInstance的三个参数:
        * 参数1：指定用哪个类加载器去将运行阶段生成的字节码加载到JVM中（可以用代理类的创建类的类加载器）
        *参数2：指定接口数组，这些接口用于指定生成的代理长什么样，也就是有哪些方法
        * 参数3：用来指定生成的代理对象要干什么事情
        * */

        //之所以能强转就是因为代理类也实现了接口
        Star proxy = (Star) Proxy.newProxyInstance(ProxyUtilJdk.class.getClassLoader(),
                new Class[]{Star.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        /*
                        * 参数1：代理对象自己
                        * 参数2：运行的方法
                        * 参数3：运行的方法的参数
                        * */
                        if ("sing".equals(method.getName())){
                            System.out.println("准备话筒");
                        }else if("dance".equals(method.getName())){
                            System.out.println("准备场地");
                        }
                        //目标方法可能会有返回值，就在这里返回
                        Object result = method.invoke(bigStarJdk, args);
                        //System.out.println("后置增强");
                        return result;
                    }
                }
        );
        return proxy;
    }
}
