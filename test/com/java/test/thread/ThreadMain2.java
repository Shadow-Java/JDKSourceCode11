package com.java.test.thread;

/**
 * @author shadow
 * @create 2024-04-22 21:45
 **/
public class ThreadMain2 {

    public static void main(String[] args) {
        final Object lock = new Object();
        Thread threadA = new Thread(()->{
            synchronized (lock) {
                System.out.println("Thread A start");
                try {
                    //当前对象的wait会阻塞当前线程
                    lock.wait();
                    System.out.println("执行wait后面的程序");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread A resume");
                System.out.println("Thread A end");
            }
        });
        Thread threadB = new Thread(()->{
            synchronized (lock) {
                System.out.println("Thread B start");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                //可以中断线程A的动作
                //threadA.interrupt();
                System.out.println("Thread B notifying");
                //wait后使用notify唤醒
                lock.notify();
                System.out.println("Thread B end");
            }
        });
        threadA.start();
        threadB.start();
    }


}
