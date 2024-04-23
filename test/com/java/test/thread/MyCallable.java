package com.java.test.thread;

import java.util.concurrent.Callable;

/**
 * @author shadow
 * @create 2024-04-23 20:33
 **/
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "Callable invoke";
    }
}
