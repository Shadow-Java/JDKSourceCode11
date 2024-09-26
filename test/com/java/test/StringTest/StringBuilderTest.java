package com.java.test.StringTest;

/**
 * @author shadow
 * @create 2024-09-01 12:58
 **/
public class StringBuilderTest {

    /**
     * StringBuilder不是线程安全的，内部也是用数组实现byte[] value;但不是final
     *
     */
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                sb.append("123");
                sb.append("456");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                sb.append("789");
                sb.append("1011");
            }
        });
        thread.start();
        thread2.start();
        try{
            thread.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(sb);
    }

}
