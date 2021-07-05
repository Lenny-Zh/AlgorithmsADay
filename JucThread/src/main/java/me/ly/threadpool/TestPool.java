package me.ly.threadpool;

import java.util.concurrent.*;

public class TestPool {


    public TestPool() {
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> finish_it_ = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                System.out.println("thread is down ");
                return "ok";
            }
        });

        System.out.println("enter waite ");
        try {
            String o = finish_it_.get();
            System.out.println(" result is " + o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
