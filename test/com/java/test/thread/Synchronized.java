package com.java.test.thread;

/**
 * 以下方式都是可重入锁，即同一个线程可以多次获取同一个锁对象，防止自己被自己阻塞
 * @author shadow
 * @create 2024-04-22 23:20
 **/
public class Synchronized {

    public synchronized static void test() {
        System.out.println("类锁，对所有的实例有效");
    }

    public synchronized void test2() {
        System.out.println("实例对象锁，对当前实例有效");
    }


    public void test3() {
        // 非线程安全的代码
        synchronized (this) {
            // 线程安全的代码块
            System.out.println("实例对象锁，只对当前实例对象有效");
        }
    }

    public void test4() {
        // 非线程安全的代码
        synchronized (Synchronized.class) {
            // 线程安全的代码
            System.out.println("类锁，对所有实例有效");
        }
    }

}
