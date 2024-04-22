package com.java.test.thread;

/**
 * 什么是线程中断状态？什么是线程阻塞状态
 * 阻塞是park，中断是interrupt
 * @author shadow
 * @create 2024-04-22 21:12
 **/
public class ThreadMain {

    static class ThreadTest implements Runnable {

        @Override
        public void run() {
            //中断的目的就是线程执行睡眠时，可以让其他线程进行中断
            //wait、jion、sleep这些方法都能抛出线程中断异常
            //wait、jion、sleep都能进入阻塞状态，但是能被其他线程中断
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().isInterrupted());
            try {
                System.out.println(Thread.currentThread().getState());
                Thread.sleep(10000);
                //被中断了  不会执行
                System.out.println("中断后的执行");
            } catch (InterruptedException e){
                System.out.println("线程中断了，不能睡眠");
            }
            System.out.println(Thread.currentThread().isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadTest());
        System.out.println(thread.getState());

    }
}
