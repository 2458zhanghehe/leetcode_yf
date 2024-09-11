package com.company.Shousi.JUC.pool;

import java.util.concurrent.*;

public class TestExecuteAndSubmit {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 1,
                10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(20));

        try{
            poolExecutor.execute(()->{
                System.out.println("executor执行");
                int a = 1/0;
            });
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("捕获到了execute抛出的异常");
        }


        Future<Integer> future = poolExecutor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("submit执行");
                int a = 1 / 0;
                return 1;
            }
        });
        try{
            Integer integer = future.get();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("抓到了get抛出的异常");
        }

        poolExecutor.shutdown();
    }
}
