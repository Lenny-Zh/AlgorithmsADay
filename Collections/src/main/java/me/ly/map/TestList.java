package me.ly.map;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class TestList {

//    public static void main(String[] args) {
//        ArrayList list = new ArrayList();
//        ArrayBlockingQueue queue = new ArrayBlockingQueue(2);
//
//    }

    public static void main(String[] args) {
        printDefaultCapacityList();
        printEmptyCapacityList();
    }

    public static void printDefaultCapacityList() {
        ArrayList defaultCapacity = new ArrayList();
        System.out.println(
                "default 初始化长度：" + getCapacity(defaultCapacity));

        defaultCapacity.add(1);
        System.out.println(
                "default add 之后 长度：" + getCapacity(defaultCapacity));
    }

    public static void printEmptyCapacityList() {
        ArrayList emptyCapacity = new ArrayList(0);
        System.out.println(
                "empty 初始化长度：" + getCapacity(emptyCapacity));

        emptyCapacity.add(1);
        System.out.println(
                "empty add 之后 长度：" + getCapacity(emptyCapacity));
    }

    public static int getCapacity(ArrayList<?> arrayList) {
        Class<ArrayList> arrayListClass = ArrayList.class;
        try {
            // 获取 elementData 字段
            Field field = arrayListClass.getDeclaredField("elementData");
            // 开启访问权限
            field.setAccessible(true);
            // 把示例传入get，获取实例字段elementData的值
            Object[] objects = (Object[]) field.get(arrayList);
            //返回当前ArrayList实例的容量值
            return objects.length;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
