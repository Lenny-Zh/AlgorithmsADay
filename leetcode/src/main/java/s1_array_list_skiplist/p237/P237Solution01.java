package s1_array_list_skiplist.p237;

import s1_array_list_skiplist.ListNode;

/**
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
 * <p>
 *  
 * <p>
 * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 * <p>
 */
public class P237Solution01 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
