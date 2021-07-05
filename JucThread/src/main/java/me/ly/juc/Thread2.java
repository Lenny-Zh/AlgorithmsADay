package me.ly.juc;

public class Thread2 {
    public void m4t1() {
        synchronized(this) {
            int i = 5;
            while( i-- > 0) {
                System.out.println(Thread.currentThread().getName() + "_synchronized"+" : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            }
        }
    }
    public void m4t2() {
        //其实 synchronized 全用来修饰代码块也可以，把方法的所有代码都包进去就相当于修饰方法（作用上）
        synchronized(this) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            }
        }
    }

    public static void main(String[] args) {
        final Thread2 myt2 = new Thread2();
        Thread t1 = new Thread(  new Runnable() {  public void run() {  myt2.m4t1();  }  }, "t1"  );
        //java多线程实际上是实现了run()方法的多线程，所以构造器里面只要构造他的run()方法即可
        Thread t2 = new Thread(  new Runnable() {  public void run() { myt2.m4t2();   }  }, "t2"  );
        t1.start();
        t2.start();
    }
}

