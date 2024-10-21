package com.java.test.StringTest;

import com.java.test.product.ConsumerThread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author shadow
 * @create 2024-09-01 13:17
 **/
public class StringBufferTest {

    public static void main(String[] args) {
        String test1 = "Hello",test2 = "123",test3 = "456",test4 = "789",test5 = "1011";
        for (int i = 0; i < 5000; i++) {
            StringBuffer sb = new StringBuffer();
            sb.append(test1);
            /**
             * 每次只会执行一个线程，
             * 如果定义超过一个线程，那么同时会至少有两个任务执行，那个任务都可能先执行；那么最后的结果不一定是res
             */
            ExecutorService executorService = Executors.newFixedThreadPool(1);
            executorService.submit(()->sb.append(test2));
            executorService.submit(()->sb.append(test3));
            executorService.submit(()->sb.append(test4));
            executorService.submit(()->sb.append(test5));
            executorService.shutdown();
            /**
             * 重复执行判断该状态，完毕后才玩后执行，不然一直等待
             */
            while (!executorService.isTerminated()) {

            }
            final String res = test1+test2+test3+test4+test5;
            if(!res.equals(sb.toString())) {
                System.out.println("不是线程安全的");
                System.out.println(sb.toString()+":"+res);
            }
        }
        System.out.println("测试完毕，线程安全");
    }
}
