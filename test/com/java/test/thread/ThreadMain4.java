package com.java.test.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author shadow
 * @create 2024-09-07 14:32
 **/
public class ThreadMain4 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*ExecutorService executorService = Executors.newFixedThreadPool(10);
        FutureTask<String> futureTask = new FutureTask<>(()->{
            long startTime = System.currentTimeMillis();
            System.out.println("future执行开始");
            try {
                //模拟线程执行
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("future执行了"+(endTime-startTime)+"ms");
            return "这是个callable方法，有两种使用方式，一种定义一个FutureTask然后交给thread；一种直接交给线程池";
        });
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
        Future<String> future = executorService.submit(()->"Hello");
        String result = future.get();
        System.out.println(result);

        Future<String> future1 = executorService.submit(()->{
            long startTime = System.currentTimeMillis();
            System.out.println("线程执行开始");
            try {
                //模拟线程执行
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("线程执行了"+(endTime-startTime)+"ms");
        },"Task result");
        System.out.println("执行完毕："+future1.get());
        executorService.shutdown();*/

        // 创建一个已经完成的 CompletableFuture
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Initial computation: 42");
            return 42;
        });

        // 立即返回一个值，进行其他计算
        future.thenApplyAsync(result -> {
            System.out.println("Async computation with result: " + result);
            return result * 2;
        }).thenAcceptAsync(finalResult -> {
            System.out.println("Final async result: " + finalResult);
        });

        // 保持主线程运行一段时间，等待异步计算完成
        try {
            Thread.sleep(2000); // 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
