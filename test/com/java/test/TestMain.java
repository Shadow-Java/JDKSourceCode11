package com.java.test;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author shadow
 * @create 2024-04-21 14:39
 **/
public class TestMain {

    public static void main(String[] args) {
        Executors.newFixedThreadPool(2, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        });
    }

}
