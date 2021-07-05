package s1_array_list_skiplist.p19;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import s1_array_list_skiplist.ListNode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 */


public class P19Solution01 {


    public ListNode removeNthFromEnd(ListNode head, int n) {

        return null;
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(7))));
        ListNode listNode = removeNthFromEnd(l1, 2);
        System.out.println(JSON.toJSONString(listNode.val));
    }



}
