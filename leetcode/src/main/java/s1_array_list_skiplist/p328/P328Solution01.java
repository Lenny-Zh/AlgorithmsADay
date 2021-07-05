package s1_array_list_skiplist.p328;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import s1_array_list_skiplist.ListNode;

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 */
public class P328Solution01 {

    public ListNode oddEvenList(ListNode head) {

        ListNode odd = new ListNode(0);
        ListNode curO = odd;

        ListNode even = new ListNode(0);
        ListNode curE = even;

        int i = 1;
        while (head != null) {
            if ((i & 1) != 1) {
                curE.next = new ListNode(head.val);
                curE = curE.next;
            } else {
                curO.next = new ListNode(head.val);
                curO = curO.next;
            }
            head = head.next;
            i++;
        }

        curO.next = even.next;
        return odd.next;
    }

    @Test
    public void test() {
        ListNode listNode = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        ListNode listNode1 = oddEvenList(listNode);
        System.out.println(JSON.toJSON(listNode1));

    }
}
