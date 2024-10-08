package com.java.test.lock;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shadow
 * @create 2024-09-18 21:45
 **/
public class ConditionTest2 {

    private int queueSize = 10;
    private PriorityQueue<Integer> queue = new PriorityQueue<Integer>(queueSize);
    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public static void main(String[] args) throws InterruptedException  {
        ConditionTest2 test = new ConditionTest2();
        //当队列不满时，让生产者产生数据
        Producer producer = test.new Producer();
        //当队列不是空的，让消费者消费数据
        Consumer consumer = test.new Consumer();
        producer.start();
        consumer.start();
        Thread.sleep(0);
        producer.interrupt();
        consumer.interrupt();
    }

    class Consumer extends Thread{
        @Override
        public void run() {
            consume();
        }
        volatile boolean flag=true;
        private void consume() {
            while(flag){
                lock.lock();
                try {
                    while(queue.isEmpty()) {
                        try {
                            System.out.println("队列空，等待数据");
                            //不是空阻塞，
                            notEmpty.await();
                        } catch (InterruptedException e) {
                            flag =false;
                        }
                    }
                    queue.poll();                //每次移走队首元素
                    notFull.signal();
                    System.out.println("从队列取走一个元素，队列剩余"+queue.size()+"个元素");
                } finally{
                    lock.unlock();
                }
            }
        }
    }

    class Producer extends Thread{
        @Override
        public void run() {
            produce();
        }
        volatile boolean flag=true;
        private void produce() {
            while(flag){
                lock.lock();
                try {
                    while(queue.size() == queueSize) {
                        try {
                            System.out.println("队列满，等待有空余空间");
                            notFull.await();
                        } catch (InterruptedException e) {

                            flag =false;
                        }
                    }
                    queue.offer(1);        //每次插入一个元素
                    notEmpty.signal();
                    System.out.println("向队列取中插入一个元素，队列剩余空间："+(queueSize-queue.size()));
                } finally{
                    lock.unlock();
                }
            }
        }
    }

}
