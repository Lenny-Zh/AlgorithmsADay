package me.ly.threadpool;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        semaphore.tryAcquire(2);

        semaphore.release(2);

        ReentrantLock lock = new ReentrantLock();
        lock.unlock();


    }
}
