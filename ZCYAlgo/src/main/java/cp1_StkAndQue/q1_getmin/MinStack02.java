package cp1_StkAndQue.q1_getmin;

import java.util.Stack;

/**
 * 执行用时 :
 * 20 ms
 * , 在所有 Java 提交中击败了
 * 51.35%
 * 的用户
 * 内存消耗 :
 * 41.7 MB
 * , 在所有 Java 提交中击败了
 * 100.00%
 * 的用户
 */
public class MinStack02 {

    private Stack<Integer> stackNor;
    private Stack<Integer> stackMin;

    public MinStack02() {
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
            }
        }

        stackNor.push(x);
    }

    public void pop() {
        if (!stackNor.isEmpty()) {
            Integer elm = stackNor.pop();
            if (elm != null) {
                Integer minElm = stackMin.peek();
                if (minElm.equals(elm)) {
                    stackMin.pop();
                }
            }
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
