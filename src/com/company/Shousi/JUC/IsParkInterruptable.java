package com.company.Shousi.JUC;

import java.util.concurrent.locks.LockSupport;
import java.util.logging.Logger;

//park可以被打断
public class IsParkInterruptable {
    private static final Logger logger = Logger.getLogger(IsParkInterruptable.class.getName());
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info("线程1 park");
                LockSupport.park();
                logger.info("线程1 park结束");
            }
        }, "t1");
        t1.start();
        Thread.sleep(1000);
        logger.info("打断线程1");
        t1.interrupt();
        Thread.sleep(3000);
        logger.info("unpark线程1");
        LockSupport.unpark(t1);
    }
}
