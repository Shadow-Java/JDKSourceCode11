package com.java.test.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author shadow
 * @create 2024-10-21 20:23
 **/
public class DequeueTest {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        //add方法返回值为void，且会抛出异常。offer是返回的是boolean值，且引用的add方法。push是加入栈的头节点addFirst
        Deque<Integer> deque = new LinkedList<>();
        Deque<Integer> deque2 = new ArrayDeque<>();
        Deque<Integer> deque3 = new LinkedBlockingDeque<>();
    }

}
