package me.ly.threadpool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {

    public static void main(String[] args) {

        int time = 5;
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
            System.out.println("执行完毕, 哈哈哈");
        });


        ExecutorService executorService = Executors.newFixedThreadPool(5);

        while (time-- > 0) {
            executorService.execute(() -> {
                try {
                    System.out.println("开始等待" + Thread.currentThread().getName());
                    try {
                        cyclicBarrier.await();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println("结束等待" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }
}
