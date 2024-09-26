package com.java.test.synchrony;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shadow
 * @create 2024-09-11 21:40
 **/
public class ReentrantLockTest {

    public static void main(String[] args) {
        /**
         * 公平锁
         */
        ReentrantLock reentrantLock = new ReentrantLock(true);
        try{
            reentrantLock.lock();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

}
