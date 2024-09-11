package com.company.Shousi.JUC;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

//手写一个原子整数类 面试容易问的原理
public class MyAtomicInteger {
    private volatile int value;
    private static final long valueOffset;
    private static final Unsafe UNSAFE;

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            UNSAFE = (Unsafe) theUnsafe.get(null);
            valueOffset = UNSAFE.objectFieldOffset(MyAtomicInteger.class.getDeclaredField("value"));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public MyAtomicInteger(int value){
        this.value = value;
    }

    public int get(){
        return value;
    }

    //写一个减的
    public void decrement(int amount){
        while(true){
            int prev = value;
            int next = prev - amount;
            if(UNSAFE.compareAndSwapInt(this,valueOffset,prev,next)){
                break;
            }
        }
    }





}
