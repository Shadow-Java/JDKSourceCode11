package com.java.test.product;

/**
 * @author shadow
 * @create 2024-04-25 03:57
 **/
public class TestMain {

    public static void main(String[] args) throws InterruptedException {
        MyQueue myQueue = new MyQueue();
        new ConsumerThread(myQueue).start();
        new ProducerThread(myQueue).start();

        Thread.sleep(10000);
        // 进程结束
        System.exit(0);
    }

}
