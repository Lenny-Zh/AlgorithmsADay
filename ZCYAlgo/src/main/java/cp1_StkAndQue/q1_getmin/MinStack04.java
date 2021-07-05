package cp1_StkAndQue.q1_getmin;

import java.util.Stack;


public class MinStack04 {

    Integer min = Integer.MAX_VALUE;
    private Stack<Integer> stackNor = new Stack<>();

    public void push(Integer x) {
        if (x <= min) {
            stackNor.push(min);
            min = x;
        }
        stackNor.push(x);
    }

    public void pop() {
        if (!stackNor.isEmpty()) {
            if (stackNor.pop().equals(min)) {
                min = stackNor.pop();
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
        return min;
    }
}
