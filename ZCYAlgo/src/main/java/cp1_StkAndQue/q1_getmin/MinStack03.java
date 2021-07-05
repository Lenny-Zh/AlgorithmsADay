package cp1_StkAndQue.q1_getmin;

import java.util.Stack;

/**
 * 执行用时 :
 * 19 ms
 * , 在所有 Java 提交中击败了
 * 78.94%
 * 的用户
 * 内存消耗 :
 * 41.6 MB
 * , 在所有 Java 提交中击败了
 * 100.00%
 * 的用户
 */


public class MinStack03 {

    private Stack<Integer> stackNor;
    private Stack<Integer> stackMin;

    public MinStack03() {
        stackNor = new Stack<Integer>();
        stackMin = new Stack<Integer>();
    }

    public void push(int x) {
        if (stackMin.isEmpty()) {
            stackMin.push(x);
        } else {
            int elm = stackMin.peek();
            if (elm >= x) {
                stackMin.push(x);
            } else {
                stackMin.push(elm);
            }
        }
        stackNor.push(x);
    }

    public void pop() {
        if (!stackNor.isEmpty()) {
            stackNor.pop();
            stackMin.pop();
        }
    }

    public int top() {
        if (stackNor.isEmpty()) {
            return 0;
        }
        return stackNor.peek();
    }

    public int getMin() {
        if (stackMin.isEmpty()) {
            return 0;
        }
        return stackMin.peek();
    }
}
