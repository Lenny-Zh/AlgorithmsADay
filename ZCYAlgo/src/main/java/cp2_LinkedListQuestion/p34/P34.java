package cp2_LinkedListQuestion.p34;

import org.junit.Test;

import java.util.LinkedList;

/**
 * Created by Administrator on 2017/8/17 0017.
 * 打印两个链表的公共部分
 * 给两个有序链表的head1 和 head2 , 打印公共部分
 *
 * 难度 士 * , 1级
 */
public class P34 {

    @Test
    public void TestP34(){
        LinkedList<Integer> list1 = getList1(1);
        LinkedList<Integer> list2 = getList1(5);

    }

    private void getCommonPartV1(){

    }


    private LinkedList<Integer> getList1(int start){
        LinkedList<Integer> list = new LinkedList<Integer>();
        for ( int i=0  ; i < 10 ; i++ ){
            list.add(start++);
        }
        return list;
    }

    class Node{
        public Integer value;
        public Node next;
        public Node prev;
        public Node(Integer data){
            this.value = data;
        }
    }

    class MyList{
        public Node node;
        public void add(Integer i){
            Node newNode = new Node(i);
            // 不好测试
        }
    }
}
