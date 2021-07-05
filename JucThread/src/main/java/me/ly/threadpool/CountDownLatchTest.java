package me.ly.threadpool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {

    public static void main(String[] args) {
        int time = 5;
        final CountDownLatch latch = new CountDownLatch(5);
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        int tc = 10_100000;


        while (time-- > 0) {
            executorService.execute(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("finish" + Thread.currentThread().getName());
                latch.countDown();
            });
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish");


    }
}
