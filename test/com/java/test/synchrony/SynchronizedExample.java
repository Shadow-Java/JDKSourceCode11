package com.java.test.synchrony;

/**
 * @author shadow
 * @create 2024-04-25 04:42
 **/
public class SynchronizedExample {

    protected static int num = 0;

    /**
     * 无锁状态
     */
    protected void numberOff() {
        for(int i=0; i<5; i++) {
            num++;
            System.out.println(Thread.currentThread().getName()+":"+SynchronizedExample.num);
        }
    }

    /**
     * 实例对象锁状态：每个线程执行五次，但num值是依次递增的
     */
    protected synchronized void numberOff2() {
        for(int i=0; i<5; i++) {
            num++;
            System.out.println(Thread.currentThread().getName()+":"+SynchronizedExample.num);
        }
    }

    /**
     * 实例对象锁状态：每个线程执行五次，但num值是依次递增的
     */
    protected void numberOff3() {
        synchronized (this) {
            for(int i=0; i<5; i++) {
                num++;
                System.out.println(Thread.currentThread().getName()+":"+SynchronizedExample.num);
            }
        }
    }



    public static void main(String[] args) throws InterruptedException {
        SynchronizedExample se = new SynchronizedExample();
        for(int i=1; i<=3; i++) {
            new Thread( ()->  {se.numberOff3();}, "线程"+i).start();
        }
    }

}
