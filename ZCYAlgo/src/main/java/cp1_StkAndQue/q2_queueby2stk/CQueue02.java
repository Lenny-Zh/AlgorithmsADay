package cp1_StkAndQue.q2_queueby2stk;

import java.util.Stack;

/**
 * 执行用时 :
 * 1859 ms
 * , 在所有 Java 提交中击败了
 * 5.04%
 * 的用户
 * 内存消耗 :
 * 44.3 MB
 * , 在所有 Java 提交中击败了
 * 100.00%
 * 的用户
 */

@Deprecated
public class CQueue02 {

    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public CQueue02() {
        this.stackIn = new Stack<>();
        this.stackOut = new Stack<>();
    }

    public void appendTail(int value) {
        stackIn.push(value);
    }

    public int deleteHead() {
        if (stackIn.isEmpty() || stackOut.isEmpty()) {
            return -1;
        }
        if (stackOut.isEmpty() && stackIn.size() == 1) {
            return stackIn.pop();
        } else if (stackOut.isEmpty() && stackIn.size() > 1) {
            stackIn.forEach(e -> {
                stackOut.push(e);
            });

            int res = stackOut.pop();
            stackOut.forEach(e -> {
                stackIn.push(e);
            });
            return res;
        }
        return 0;
    }

}
