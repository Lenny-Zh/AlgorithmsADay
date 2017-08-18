package cp2_LinkedListQuestion.p35;

import Util.ListUtil;
import org.junit.Test;

import java.util.LinkedList;

/**
 * Created by Administrator on 2017/8/18 0018.
 * 单链表 双链表删除倒数第k个节点
 * 实现两个函数, 删除单链表 双链表倒数第k个节点
 * 时间复杂度为 O(N) , 额外空间复杂度为  O(1)
 *
 * 难度: 士兵 *
 */
public class P35 {

    @Test
    public void testP35(){
        LinkedList<Integer> list = ListUtil.getTestLinkedListSort();
        System.out.println(svSingleV1(list, 1));
        LinkedList<Integer> list2 = ListUtil.getTestLinkedListSort();
        svDoubleV1(list2,2);
        System.out.println(list2);
    }

    private LinkedList<Integer> svSingleV1(LinkedList<Integer> list , Integer k){
        Integer num = list.size() - k + 1;
        int count = 0;
        Integer remove = null;
        for (Integer i : list){
            count++;
            if (count == num){
                remove = i;
            }
        }
        list.remove(remove);
        return list;
    }


    private LinkedList<Integer> svDoubleV1(LinkedList<Integer> list , Integer k){
        LinkedList<Integer> tmeList = new LinkedList<Integer>();
        int count = 0;
        while(list.size() > 0){
            count++;
            Integer i = list.pollLast();
            if( count == k){
                break;
            }
            tmeList.add(i);
        }
        list.addAll(tmeList);
        return list;
    }


}
