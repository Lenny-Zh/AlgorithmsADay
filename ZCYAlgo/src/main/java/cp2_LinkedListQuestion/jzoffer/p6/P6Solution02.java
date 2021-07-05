package cp2_LinkedListQuestion.jzoffer.p6;

import org.junit.Test;

import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 输入：head = [1,3,2]
 * <p>
 * 输出：[2,3,1]
 */
public class P6Solution02 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        int total = 10000;
        int[] res = new int[total];
        int idx = total - 1;
        ListNode temp = head;
        while (temp != null) {
            res[idx--] = temp.val;
            temp = temp.next;
        }
        int len = total - idx - 1;
        int[] resFinal = new int[len];
        System.arraycopy(res, idx + 1, resFinal, 0, len);
        return resFinal;
    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);

        node1.next = node3;
        node3.next = node2;


        System.out.println(reversePrint(node1));
    }
}
