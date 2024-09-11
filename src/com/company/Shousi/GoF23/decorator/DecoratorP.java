package com.company.Shousi.GoF23.decorator;

import java.util.*;

//装饰器模式
//Collections里面有许多以synchronized开头的方法
//比如synchronizedMap、synchronizedList、synchronizedCollection,synchronizedSet等等
//就是用synchronized包裹一个容器，里面的方法都是在synchronized代码块内调用原容器方法。
public class DecoratorP {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        Map<String, Integer> synchronizedMap = Collections.synchronizedMap(map);

        ArrayList<Integer> list = new ArrayList<>();
        List<Integer> synchronizedList = Collections.synchronizedList(list);
    }
}
