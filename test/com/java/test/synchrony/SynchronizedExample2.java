package com.java.test.synchrony;

/**
 * @author shadow
 * @create 2024-04-25 04:49
 **/
public class SynchronizedExample2 {

    protected static int num = 0;

    /**
     * 实例对象锁状态：每个线程执行五次，但num值是依次递增的
     */
    protected void numberOff() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                num++;
                System.out.println(Thread.currentThread().getName() + ":" + SynchronizedExample2.num);
            }
        }
    }

    /**
     * 类锁：以SynchronizedExample2字节码文件为锁资源，故每个线程只要调用方法就能互斥
     */
    protected void numberOff(Object lock) {
        synchronized (SynchronizedExample2.class) {
            for (int i = 0; i < 5; i++) {
                num++;
                System.out.println(Thread.currentThread().getName() + ":" + SynchronizedExample2.num);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedExample2 se = new SynchronizedExample2();
        for(int i=1; i<=3; i++) {
            //实例对象锁，共享资源为num，但锁对象为new SynchronizedExample()
            //每个线程都有锁对象，故synchronized失效
            new Thread( ()->  {new SynchronizedExample2().numberOff(new Object());}, "队列"+i).start();
        }
    }
}
