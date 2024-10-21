package com.java.test.lock;

/**
 * @author shadow
 * @create 2024-09-18 03:34
 **/
public class WaitAndNotifyDemo {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        //主线程拿到myThread监视器锁，即对象头添加该线程被占用
        synchronized (myThread) {
            try {
                myThread.start();
                // 主线程睡眠3s
                Thread.sleep(10000);
                System.out.println("before wait");
                // 阻塞主线程，将占用该对象的线程阻塞，通过释放监视器锁，让其他线程调用唤醒该线程
                myThread.wait();
                System.out.println("after wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class MyThread extends Thread {

        public void run() {
            System.out.println("MyThread run");
            //MyThread监视器锁释放后，拿到该对象
            synchronized (this) {
                System.out.println("before notify");
                //唤醒该对象阻塞的线程，主线程重新获取监视器锁
                notify();
                System.out.println("after notify");
            }
        }
    }


}
