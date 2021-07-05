package s1_array_list_skiplist.p21;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import s1_array_list_skiplist.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 */
public class P21Solution01 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    cur.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    cur.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
            } else if (l1 == null) {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            cur = cur.next;
        }
        return res.next;
    }


    @Test
    public void test() {
        ListNode l1 = new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(7))));
        ListNode l2 = new ListNode(2, new ListNode(4, new ListNode(6, new ListNode(8))));

        ListNode listNode = mergeTwoLists(l1, l2);
        System.out.println(JSON.toJSONString(listNode));
    }


}
