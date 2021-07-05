package cp1_StkAndQue.q3_reversalStk;

import java.util.Stack;

// 看了提示
public class Solution01 {

    public static Integer getAndRemoveLast(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return null;
        }
        int temp = stack.pop();
        Integer last = getAndRemoveLast(stack);
        if (last == null) {
            last = temp;
        } else {
            stack.push(temp);
        }
        return last;
    }

    public static void reversal(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        Integer last = getAndRemoveLast(stack);
        if (last == null) {
            return;
        } else {
            reversal(stack);
        }
        stack.push(last);
    }


}
