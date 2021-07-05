package me.ly.mojo;

public class User {


    private Integer name;

    public void notSynchronizedFunc() {
        System.out.println("notSynchronized");
    }

    public synchronized void synchronizedFunc() {
        System.out.println("notSynchronized");
    }


    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }
}
