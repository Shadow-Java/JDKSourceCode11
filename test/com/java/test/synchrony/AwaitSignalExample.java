package com.java.test.synchrony;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shadow
 * @create 2024-09-11 22:05
 **/
public class AwaitSignalExample {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void before() {
        lock.lock();
        try {
            System.out.println("before开始执行");
            condition.signalAll();
            System.out.println("before执行完毕");
        } finally {
            System.out.println("before释放锁了");
            lock.unlock();
        }
    }

    public void after() {
        lock.lock();
        try {
            System.out.println("after开始执行");
            condition.await();
            System.out.println("after执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("after释放锁了");
            lock.unlock();
        }
    }

}
