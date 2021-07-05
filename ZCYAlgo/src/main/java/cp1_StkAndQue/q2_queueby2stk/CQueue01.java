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

public class CQueue01 {

    private Stack<Integer> stackA;
    private Stack<Integer> stackB;

    public CQueue01() {
        this.stackA = new Stack<>();
        this.stackB = new Stack<>();
    }

    public void appendTail(int value) {
        stackA.push(value);
        Stack<Integer> temp = new Stack<>();
        temp.addAll(stackA);
        stackB.clear();
        while (!temp.isEmpty()) {
            stackB.push(temp.pop());
        }
    }


    public int deleteHead() {
        if (stackB.isEmpty()) {
            return -1;
        }
        int resl = stackB.pop();
        Stack<Integer> temp = new Stack<>();
        temp.addAll(stackB);
        stackA.clear();
        while (!temp.isEmpty()) {
            stackA.push(temp.pop());
        }
        return resl;
    }

}
