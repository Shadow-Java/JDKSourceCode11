package com.java.test.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shadow
 * @create 2024-09-19 21:31
 **/
public class SyncAndConditionExample {

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private boolean ready = false;

    public void producer() {
        lock.lock();
        try {
            System.out.println("Producer: Waiting for consumer to signal.");
            while (!ready) {
                condition.await();  // 释放锁，并进入条件等待队列
            }
            System.out.println("Producer: Ready signal received.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();  // 恢复中断状态
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void consumer() {
        lock.lock();
        try {
            System.out.println("Consumer: Setting ready flag and signaling.");
            ready = true;
            condition.signal();  // 唤醒条件等待队列中的一个线程
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SyncAndConditionExample example = new SyncAndConditionExample();

        Thread producerThread = new Thread(example::producer, "Producer");
        Thread consumerThread = new Thread(example::consumer, "Consumer");

        producerThread.start();
        Thread.sleep(1000);  // 确保生产者先进入条件等待队列

        // 模拟一个额外的线程获取锁，阻止生产者线程立即获取同步状态
        Thread extraThread = new Thread(() -> {
            example.lock.lock();
            try {
                System.out.println("Extra Thread: Holding the lock.");
                Thread.sleep(2000);  // 持有锁一段时间
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();  // 恢复中断状态
                e.printStackTrace();
            } finally {
                System.out.println("Extra Thread: Releasing the lock.");
                example.lock.unlock();
            }
        }, "ExtraThread");
        extraThread.start();

        Thread.sleep(1000);  // 确保额外线程已经获取锁

        consumerThread.start();
    }

}
