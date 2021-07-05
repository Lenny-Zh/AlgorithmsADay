package cp1_StkAndQue.q5_stksortbystk;

import java.util.Stack;

// 看了提示
public class Solution02 {

    public static void sort(Stack<Integer> stack) {
        Stack<Integer> sortStk = new Stack<>();
        while (!stack.isEmpty()) {
            Integer val = stack.pop();
            while (!sortStk.isEmpty() && sortStk.peek() > val) {
                stack.push(sortStk.pop());
            }
            sortStk.push(val);
        }
        stack.addAll(sortStk);
    }

}
