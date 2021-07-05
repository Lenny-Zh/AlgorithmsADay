package cp1_StkAndQue.q2_queueby2stk;

import java.util.Stack;

/**
 * 执行用时 :
 * 57 ms
 * , 在所有 Java 提交中击败了
 * 74.51%
 * 的用户
 * 内存消耗 :
 * 47.8 MB
 * , 在所有 Java 提交中击败了
 * 100.00%
 * 的用户
 */

public class CQueue03 {

    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public CQueue03() {
        this.stackIn = new Stack<>();
        this.stackOut = new Stack<>();
    }

    public void appendTail(int value) {
        stackIn.push(value);
    }

    public int deleteHead() {
        if (stackIn.isEmpty() && stackOut.isEmpty()) {
            return -1;
        } else if (stackOut.isEmpty()) {
            // 初始化
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.pop();
    }

}
