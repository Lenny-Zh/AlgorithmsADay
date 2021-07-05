package s1_array_list_skiplist.p2;

import com.alibaba.fastjson.JSON;
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
public class P2Solution01 {

    /**
     * @Author ：lennyz
     * @Date: 2021/3/4 10:55 PM
     * @Desc:
     * 把链表转化为整数
     * 相加后转链表
     * 注意对其
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
        Integer l1Number = getNumb(l1);
        Integer l2Number = getNumb(l2);
        if(l1Number + l2Number == 0){
            return new ListNode(0);
        }
        return getList(l1Number + l2Number);
    }

    private int getNumb(ListNode l1) {
        int res = 0;
        int times = 1;
        do {
            res += l1.val * times;
            times *= 10;
            l1 = l1.next;
        }
        while (l1 != null);
        return res;
    }

    private ListNode getList(Integer numb) {
        if (numb == 0) {
            return null;
        }
        ListNode node = new ListNode();
        node.val = numb % 10;
        node.next = getList(numb / 10);
        return node;
    }


    @Test
    public void test() {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        System.out.println(getNumb(l1));
        System.out.println(getNumb(l2));
        ListNode node = addTwoNumbers(l1, l2);
        System.out.println(getNumb(node));

    }
}
