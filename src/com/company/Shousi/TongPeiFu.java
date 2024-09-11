package com.company.Shousi;

import java.util.ArrayList;
import java.util.List;

public class TongPeiFu {
    public static void main(String[] args) {
        List<? extends Number> numbers = new ArrayList<Integer>();
        numbers.add(null); // 这是合法的
        //numbers.add(123); // 编译错误，不能添加具体的Integer
        Number n = numbers.get(0); // 可以读取，读出来的类型是Number
    }
}
