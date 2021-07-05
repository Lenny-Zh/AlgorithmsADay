package me.ly.threadpool;

public class ThreadLocalTest {


    public static final ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("jaajajjjaj");

        new Thread(() -> {
            System.out.println("thread " + Thread.currentThread().getName());
            String s = threadLocal.get();
            System.out.println("thread " + s);
            new Thread(() -> {
                System.out.println("thread  sub " + Thread.currentThread().getName());
                String s1 = threadLocal.get();
                System.out.println("thread  sub" + s1);
            }).start();

        }).start();

        test();
        threadLocal.remove();

    }

    public static void test() {
        Object o = threadLocal.get();
        System.out.println("sub method " + o);

    }
}
