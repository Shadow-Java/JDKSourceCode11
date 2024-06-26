package com.java.test.product;

import java.util.Random;

/**
 * @author shadow
 * @create 2024-04-25 03:56
 **/
public class ProducerThread extends Thread {

    private final MyQueue myQueue;
    private int index = 0;
    private final Random random = new Random();

    public ProducerThread(MyQueue myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        while (true) {
            String tmp = "生产数据：" + index;
            myQueue.put(tmp);
            System.out.println(tmp);
            index++;
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
