package me.ly.thread;

import java.util.concurrent.locks.ReentrantLock;

public class TestWait implements Runnable {

    static ReentrantLock reentrantLock = new ReentrantLock(false);

    public static void main(String arg[]) {

        Thread thread = new Thread(new TestWait());

        thread.start();
    }

    public static void sync() {
        System.out.println(Thread.currentThread() + " wait ");
        try {
            new Object().wait(200);
            System.out.println(Thread.currentThread() + " release ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        sync();
    }
}
