package com.java.test.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author shadow
 * @create 2024-09-07 15:30
 **/
public class ExecutorServiceTest {

    public static void main(String[] args) throws InterruptedException {
        int threadSize = 1000;
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        for (int i = 0; i < threadSize; i++) {
            executorService.execute(() -> {
                example(1);
                System.out.println("执行"+Thread.currentThread().getName());
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
    }

    private static void example(int i) {
        i++;
        System.out.println(i);
    }

}
