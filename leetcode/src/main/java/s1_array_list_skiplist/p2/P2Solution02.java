package s1_array_list_skiplist.p2;

import org.junit.Test;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。
 * 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 实例:
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * 提示：
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 */
public class P2Solution02 {

    /**
     * @Author ：lennyz
     * @Date: 2021/3/4 10:55 PM
     * @Desc:
     * 遍历两个链表,对其部位
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode cur = node;

        boolean flag = false;
        while (l1 != null || l2!=null){
            Integer val1 = l1 == null ? 0 : l1.val;
            Integer val2 = l2 == null ? 0 : l2.val;
            Integer res = val1 + val2 + (flag?1:0);

            flag = (res > 9);

            cur.next = new ListNode(res%10);

            cur = cur.next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if(flag ) {
            cur.next = new ListNode(1);
        }
        return node.next;
    }



    @Test
    public void test() {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode node = addTwoNumbers(l1, l2);
        System.out.println(node.val);
    }
}
