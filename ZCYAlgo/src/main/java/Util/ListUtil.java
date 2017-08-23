package Util;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Administrator on 2017/8/18 0018.
 */
public class ListUtil {

    public static LinkedList<Integer> getTestLinkedListSort(){
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        return list;
    }

    public static ArrayList<Integer> getTestArrayListSort(){
        ArrayList<Integer> list = new ArrayList<Integer>(10);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        return list;
    }


}
