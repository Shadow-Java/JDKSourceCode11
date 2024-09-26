package com.java.test.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shadow
 * @create 2024-09-17 19:34
 **/
public class AtomicIntergerTest {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.incrementAndGet();
    }

}
