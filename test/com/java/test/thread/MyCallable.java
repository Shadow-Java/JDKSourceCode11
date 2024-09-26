package com.java.test.thread;

import java.util.concurrent.Callable;

/**
 * 这是个callable方法，有两种使用方式，一种定义一个FutureTask然后交给thread；一种直接交给线程池
 * @author shadow
 * @create 2024-04-23 20:33
 **/
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "Callable invoke";
    }
}
