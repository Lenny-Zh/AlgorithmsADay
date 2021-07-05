package s1_array_list_skiplist.p141;

import org.junit.Test;
import s1_array_list_skiplist.ListNode;


/**
 * @Author ：lennyz
 * @Date: 2021/5/1 5:57 PM
 * @Desc: 给定一个链表，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * <p>
 *  
 * 进阶：
 * <p>
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 */

public class P141Solution02 {


    //  * 你能用 O(1)（即，常量）内存解决此问题吗？
    // 快慢指针法
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;

    }

    @Test
    public void test() {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);

        node.next = node1;
        node3.next = node1;
        node1.next = node2;
        node2.next = node3;

        System.out.println(hasCycle(node));

    }
}
