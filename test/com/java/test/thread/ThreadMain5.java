package com.java.test.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * @author shadow
 * @create 2024-09-11 21:06
 **/
public class ThreadMain5 extends Thread {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread();
        t1.wait();
        t1.notify();
        LockSupport.park();
    }

    @Override
    public void run() {
        super.run();
    }
}
