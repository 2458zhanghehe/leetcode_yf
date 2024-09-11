package com.company.Shousi.JUC;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class TestUnSafe {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);

        //1.获取域的偏移地址
        long idOffset = unsafe.objectFieldOffset(Teacher.class.getDeclaredField("id"));
        long nameOffset = unsafe.objectFieldOffset(Teacher.class.getDeclaredField("name"));

        Teacher t = new Teacher();
        //执行cas操作
        unsafe.compareAndSwapInt(t,idOffset,0,1);
        unsafe.compareAndSwapObject(t,nameOffset,null,"张三");

        System.out.println(t.toString());
    }
}

class Teacher{
    volatile int id;
    volatile String name;

    @Override
    public String toString() {
        return id + " " + name;
    }
}
