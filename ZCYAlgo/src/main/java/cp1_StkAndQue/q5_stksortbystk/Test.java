package cp1_StkAndQue.q5_stksortbystk;


import com.alibaba.fastjson.JSON;

import java.util.Stack;

/**
 * 一个栈中元素的类型为整型，现在想将该栈从顶到底按从大到小的顺序排序，只许申请一个栈。除此之外，可以申请新的变量，但不能申请额外的数据结构。如何完成排序？
 * <p>
 * 难度 : 士　1
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
//        Solution01.sort(stack);
        Solution02.sort(stack);
        System.out.println("after :" + JSON.toJSONString(stack));

    }
}
