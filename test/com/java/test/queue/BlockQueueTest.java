package com.java.test.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @author shadow
 * @create 2024-10-21 20:44
 **/
public class BlockQueueTest {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(10);
        blockingQueue.add("123");
        blockingQueue.offer("456");
        try{
            blockingQueue.offer("789",100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try{
            blockingQueue.put("sdg");
        } catch (InterruptedException e) {

        }
        blockingQueue.add("1");
        BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>();
    }

}
