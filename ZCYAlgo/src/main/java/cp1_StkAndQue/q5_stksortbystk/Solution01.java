package cp1_StkAndQue.q5_stksortbystk;

import java.util.Stack;

// 看了提示
public class Solution01 {

    public static void sort(Stack<Integer> stack) {
        Stack<Integer> sortStk = new Stack<>();
        while (!stack.isEmpty()) {
            Integer val = stack.pop();
            if (sortStk.isEmpty()) {
                sortStk.push(val);
            } else {
                cmpSet(sortStk, val);
            }
        }
        stack.addAll(sortStk);
    }

    public static void cmpSet(Stack<Integer> stack, Integer val) {
        if (stack.isEmpty()) {
            return;
        }
        Integer elm = stack.pop();
        if (val < elm) {
            if (stack.isEmpty()) {
                stack.push(val);
            } else {
                cmpSet(stack, val);
            }
            stack.push(elm);
        } else {
            stack.push(elm);
            stack.push(val);
        }
    }

}
