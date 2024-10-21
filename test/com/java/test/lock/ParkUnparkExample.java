package com.java.test.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * @author shadow
 * @create 2024-09-18 04:13
 **/
public class ParkUnparkExample {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ": Before unpark");
            LockSupport.unpark(Thread.currentThread());
            System.out.println(Thread.currentThread().getName() + ": After unpark");

            // 线程会在这里被唤醒
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + ": After park");
        }, "Thread-1");

        t1.start();

        // 等待一会儿，确保 t1 已经执行到 LockSupport.park()
        Thread.sleep(1000);

        System.out.println("Main thread: Before unpark");
        LockSupport.unpark(t1);

    }
}
