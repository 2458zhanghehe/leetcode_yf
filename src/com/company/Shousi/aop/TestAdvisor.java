package com.company.Shousi.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;


public class TestAdvisor {
    public static void main(String[] args) {
        //1.切点
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* foo())"); //匹配所有路径的任意返回结果的foo无参方法

        //通知
        MethodInterceptor advice = new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                System.out.println("brefore......");
                Object result = invocation.proceed();
                return result;
            }
        };

        //切面
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut, advice);

        //创建代理
        Target1 target1 = new Target1();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        //这里需要主动提供target的接口，不会主动检测是否实现了接口 $Proxy数字 就是jdk实现，cglib会有cglib关键字
        proxyFactory.setInterfaces(target1.getClass().getInterfaces());
        //proxyFactory.setProxyTargetClass(true);

        proxyFactory.setTarget(target1);

        I1 proxy = (I1) proxyFactory.getProxy();
        proxy.foo();
        proxy.bar();

    }

    interface I1 {
        void foo();

        void bar();
    }

    static class Target1 implements I1 {
        public void foo() {
            System.out.println("target1 foo");
        }

        public void bar() {
            System.out.println("target1 bar");
        }
    }

    static class Target2 {
        public void foo() {
            System.out.println("target2 foo");
        }

        public void bar() {
            System.out.println("target2 bar");
        }
    }
}

