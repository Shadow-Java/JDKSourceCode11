package com.java.test.synchrony;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author shadow
 * @create 2024-09-11 22:05
 **/
public class AwaitSignalExampleTest {

    public static void main(String[] args) {
        AwaitSignalExample awaitSignalExample = new AwaitSignalExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->awaitSignalExample.after());
        executorService.execute(()->awaitSignalExample.before());
        executorService.shutdown();
    }

}
