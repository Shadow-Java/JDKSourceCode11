package com.java.test.synchrony;

/**
 * @author shadow
 * @create 2024-04-25 05:08
 **/
public class WaitOrNotify {

    private Object obj1 = new Object();

    /**
     * synchronized为什么要和wait和notify；
     * wait的语义是阻塞当前拿到该对象锁的线程
     * notify是唤醒等待获取该对象锁的线程
     * @throws InterruptedException
     */
    public void method1() throws InterruptedException {
        synchronized(obj1) {
            //...
            obj1.wait();
            //...
        }
    }

    /**
     * 为什么wait()的时候必须释放锁?<br/>
     * 当线程A进⼊synchronized(obj1)中之后，也就是对obj1上了锁。此时，调⽤wait()进⼊阻塞状态，⼀直不能退出
     * synchronized代码块；那么，线程B永远⽆法进⼊synchronized(obj1)同步块⾥，永远没有机会调⽤notify()，发⽣死
     * 锁。
     */
    public void method2() {
        synchronized(obj1) {
            //...
            obj1.notify();
            //...
        }
    }

    public synchronized void  method3() throws InterruptedException {
        //...
        this.wait();
        //...
    }

    public synchronized void method4() {
        //...
        this.notify();
        //...
    }

}
