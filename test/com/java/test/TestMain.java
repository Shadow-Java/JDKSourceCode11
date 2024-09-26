package com.java.test;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author shadow
 * @create 2024-04-21 14:39
 **/
public class TestMain {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("Hello");
        final String tes = "Hello";
        System.out.println(sb.toString().equals(tes));
    }

}
