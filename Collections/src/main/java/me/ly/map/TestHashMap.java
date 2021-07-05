package me.ly.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestHashMap {

    public static void main(String[] args) {
        HashMap<String ,String> map = new HashMap<>();
        map.size();
        System.out.println(6<<1);
        String a = "abc";
        System.out.println(a.hashCode());
        System.out.println(a.hashCode() >>> 16);
        Integer b = new Integer(1);
        System.out.println(b.equals(1));
        System.out.println(((Object) 1 ) instanceof Integer);


        Object o = new Object();
        Object o2 = new Object();

        System.out.println(o.hashCode());
        System.out.println(o2.hashCode());

        Hashtable hashtable = new Hashtable();

        Map<String, String> stringStringMap = Collections.synchronizedMap(map);

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();



    }
}
