package me.ly.thread;

import java.util.concurrent.locks.ReentrantLock;

public class TestState implements Runnable {

    static ReentrantLock reentrantLock = new ReentrantLock(false);

    public static void  main(String arg[]) {

        // 非公平


        Thread thread1 = new Thread(new TestState());

        Thread thread2 = new Thread(new TestState());

        System.out.println("thread1" + thread1.getState());
        thread1.start();
        System.out.println("thread1" + thread1.getState());



        System.out.println("thread2" + thread2.getState());
        thread2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread2" + thread2.getState());

    }

    public static void sync() {
        reentrantLock.lock();
        System.out.println(Thread.currentThread() + " get ");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        reentrantLock.unlock();
    }

    @Override
    public void run() {
        sync();
    }
}
