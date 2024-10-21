package com.java.test.thread;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author shadow
 * @create 2024-04-23 20:34
 **/
public class ThreadMain3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<>(myCallable);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }

}
