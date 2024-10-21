package com.java.test.product;

import java.util.Random;

/**
 * @author shadow
 * @create 2024-04-25 03:56
 **/
public class ConsumerThread extends Thread {

    private final MyQueue myQueue;
    private final Random random = new Random();

    public ConsumerThread(MyQueue myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        while (true) {
            String s = myQueue.get();
            System.out.println("\t\t消费的数据：" + s);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
