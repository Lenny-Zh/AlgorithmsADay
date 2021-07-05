package recursion_dc_dp.p206;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import s1_array_list_skiplist.ListNode;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class P206Solution01 {

    // 用递归解决
    public ListNode reverseList(ListNode head) {
        ListNode res = null;
        rec(res, head);
        return head;
    }

    public void rec(ListNode res, ListNode next) {
        // 终止条件
        if (next == null) {
            return;
        }

        // 处理当前
        if(res == null){

        }
    }

    @Test
    public void test() {
        ListNode list = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3))));
        ListNode res = reverseList(list);
        System.out.println(JSON.toJSONString(list));
        System.out.println(JSON.toJSONString(res));

    }
}
