package cp1_StkAndQue.q1_getmin;

/**
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 * 1. pop push getMing 时间复杂度 O(1)
 * 2. 设计的栈类型可以使用现有栈结构
 * <p>
 * 难度 士 1
 */

public class Q1Getmin {

    public static void main(String[] args) {

//        MinStack01 stackGetMin01 = new MinStack01();
//        MinStack02 stackGetMin01 = new MinStack02();
//        MinStack03 stackGetMin01 = new MinStack03();

        MinStack04 stackGetMin01 = new MinStack04();
        int total = 200;
        long cnt = 40;
        while (cnt-- > 0) {
            int num = Long.valueOf(Math.round(Math.random() * total)).intValue();
            System.out.println("输入 " + num);
            stackGetMin01.push(num);
        }
        System.out.println("getMin " + stackGetMin01.getMin());
        System.out.println("getTop " + stackGetMin01.top());
        System.out.println("pop ");
        stackGetMin01.pop();
        System.out.println("getMin " + stackGetMin01.getMin());

    }


}
