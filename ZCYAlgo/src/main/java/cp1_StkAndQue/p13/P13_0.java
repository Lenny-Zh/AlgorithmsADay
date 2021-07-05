package cp1_StkAndQue.p13;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by solid on 16-12-15.
 * 理解错题目意思,重写
 * 功能: 设计一个静态方法,让传入的栈参数从大到小排列顺序
 * 条件: 静态方法中只允许申请一个栈.可以申请新的变量,不能申请额外数据结构
 * 难度: 士 *
 */
public class P13_0 {

    @Test
    public void testPush() {
        System.out.println("test refactStack begin ! ");
        Stack<Integer> myStack = new Stack<Integer>();
        myStack.push(1);
        myStack.push(4);
        myStack.push(6);
        myStack.push(2);
        myStack.push(5);
        myStack.push(3);
        myStack.push(7);
        refactStack(myStack);
        while (!myStack.empty()) {
            System.out.println(myStack.pop());
        }
        List<String> list = new ArrayList<String>();
    }

    public static void refactStack(Stack<Integer> stack) {
        Stack<Integer> stackH = new Stack<Integer>();
        while (!stack.empty()) {
            Integer tmp = stack.pop();
            while (!stackH.empty() && tmp > stackH.peek()) {
                stack.push(stackH.pop());
            }
            stackH.push(tmp);
        }
        while (!stackH.empty()) {
            stack.push(stackH.pop());
        }
    }
}



