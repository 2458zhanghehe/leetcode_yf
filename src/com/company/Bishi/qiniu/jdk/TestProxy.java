package com.company.Bishi.qiniu.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TestProxy {
    public static void main(String[] args) {
        BigStar bigStar = new BigStar("周杰伦");
        MyProxy proxy = new MyProxy(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if("sing".equals(method.getName())){
                    System.out.println("准备一个话筒");
                }else if("dance".equals(method.getName())){
                    System.out.println("准备一个场地");
                }
                Object result = method.invoke(bigStar, args);
                return result;
            }
        });

        proxy.sing("告白气球");
        String ans = proxy.dance();
        System.out.println(ans);

    }

}
