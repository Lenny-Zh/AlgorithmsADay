package cp1_StkAndQue.q1_getmin;

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


public class MinStack01 {

    private Stack<Integer> stackNor;
    private Stack<Integer> stackMin;

    public MinStack01() {
        stackNor = new Stack<Integer>();
        stackMin = new Stack<Integer>();
    }

    public void push(int x) {
        if (stackMin.isEmpty()) {
            stackMin.push(x);
        } else {
            Stack<Integer> stackTemp = new Stack<>();
            while (!stackMin.isEmpty()) {
                int elm = stackMin.pop();
                if (elm < x) {
                    stackTemp.push(elm);
                    if (stackMin.isEmpty()) {
                        stackMin.push(x);
                        break;
                    }
                } else if (elm >= x) {
                    stackMin.push(elm);
                    stackMin.push(x);
                    break;
                }
            }
            while (!stackTemp.isEmpty()) {
                stackMin.push(stackTemp.pop());
            }
        }
        stackNor.push(x);
    }

    public void pop() {
        if (!stackNor.isEmpty()) {
            Integer elm = stackNor.pop();
            if (elm != null) {
                Stack<Integer> stackTemp = new Stack<>();
                while (!stackMin.isEmpty()) {
                    Integer mElm = stackMin.pop();
                    if (mElm.equals(elm)) {
                        break;
                    } else {
                        stackTemp.push(mElm);
                    }
                }
                while (!stackTemp.isEmpty()) {
                    stackMin.push(stackTemp.pop());
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
