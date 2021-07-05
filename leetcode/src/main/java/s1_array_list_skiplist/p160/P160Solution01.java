package s1_array_list_skiplist.p160;

import org.junit.Test;
import s1_array_list_skiplist.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ：lennyz
 * @Date: 2021/5/2 4:26 PM
 * @Desc: 编写一个程序，找到两个单链表相交的起始节点。
 * 输入：
 * intersectVal = 8,
 * listA = [4,1,8,4,5],
 * listB = [5,0,1,8,4,5],
 * skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 */
public class P160Solution01 {

    // 哈希发 时间复杂度  O(m+n) 空间复杂度 O(m) 或者 O(n)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> hashSet = new HashSet<>();

        ListNode curNode = headA;
        while (curNode != null) {
            hashSet.add(curNode);
            curNode = curNode.next;
        }

        curNode = headB;
        while (curNode != null) {
            if (hashSet.contains(curNode)) {
                return curNode;
            }
            curNode = curNode.next;
        }
        return null;
    }


    @Test
    public void test() {

        ListNode listNodeA = new ListNode(9);


        ListNode listNodeB = new ListNode(11);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);

        listNodeA.next = listNode2;
        listNode2.next = listNode4;
        listNode4.next = listNode5;

        listNodeB.next = listNode3;
        listNode3.next = listNode5;

        listNode5.next = listNode6;


    }


}
