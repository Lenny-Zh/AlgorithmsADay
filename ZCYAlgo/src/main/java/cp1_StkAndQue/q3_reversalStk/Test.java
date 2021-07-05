package cp1_StkAndQue.q3_reversalStk;

import com.alibaba.fastjson.JSON;

import java.util.Stack;

/**
 * 一个栈依次压入1、2、3、4、5，
 * 那么从栈顶到栈底分别为5、4、3、2、1
 * 将这个栈转置后，从栈顶到栈底为1、2、3、4、5，
 * 也就是实现栈中元素的逆序，
 * 但是只能用递归函数来实现，不能用其他数据结构。
 *
 * <p>
 * 难度 : 尉 2
 */
public class Test {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int total = 20;
        int cnt = 5;
        while (cnt-- > 0) {
            int num = Long.valueOf(Math.round(Math.random() * total)).intValue();
            System.out.println("in: " + num);
            stack.push(num);
        }

        System.out.println("before :" + JSON.toJSONString(stack));
        Solution01.reversal(stack);
        System.out.println("after :" + JSON.toJSONString(stack));

    }
}
