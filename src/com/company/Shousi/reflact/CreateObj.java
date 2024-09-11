package com.company.Shousi.reflact;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//快手一面这里栽了
public class CreateObj {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //1 加载并初始化指定的类Person
        Class<?> personClass = Class.forName("com.company.Shousi.reflact.Person");
        //2.1 获取无参构造方法
        Constructor<?> constructor1 = personClass.getConstructor();
        //2.1.1 newInstance创造实例
        Person person1 = (Person) constructor1.newInstance();
        person1.run("dsad");

        // 2.2 获取有参构造方法
        Constructor<?> constructor2 = personClass.getConstructor(String.class, int.class);
        // 2.2.1 newInstance创造实例
        Person Alice = (Person) constructor2.newInstance("Alice", 24);
        Alice.run("das");

        //2.3 获取公共方法
        Method runMethod = personClass.getMethod("run", String.class);
        runMethod.invoke(person1, "fds");

        //2.4 获取私有方法
        Method jumpMethod = personClass.getDeclaredMethod("jump", int.class);
        // 2.4.1 设置访问权限
        jumpMethod.setAccessible(true);
        jumpMethod.invoke(person1, 10);
    }
}
