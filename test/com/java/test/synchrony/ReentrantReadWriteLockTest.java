package com.java.test.synchrony;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author shadow
 * @create 2024-10-01 12:37
 **/
public class ReentrantReadWriteLockTest {

    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        ConcurrentHashMap<String,String> hashMap = new ConcurrentHashMap<>();
        hashMap.put("123","345");
    }

}
