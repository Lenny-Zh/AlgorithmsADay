package cp1_StkAndQue.q2_queueby2stk;

/**
 * 编写一个类，用两个栈实现队列，支持队列的基本操作（add、poll、peek）。
 * <p>
 * 难度 : 尉 2
 */
public class Test {

    public static void main(String[] args) {
        CQueue03 queue01 = new CQueue03();
        int total = 20;
        int cnt = 5;
        while (cnt-- > 0) {
            int num = Long.valueOf(Math.round(Math.random() * total)).intValue();
            System.out.println("in: " + num);
            queue01.appendTail(num);
        }

        cnt = 2;
        while (cnt-- > 0) {
            int num = queue01.deleteHead();
            System.out.println("out: " + num);
        }

        cnt = 3;
        while (cnt-- > 0) {
            int num = Long.valueOf(Math.round(Math.random() * total)).intValue();
            System.out.println("in: " + num);
            queue01.appendTail(num);
        }


        cnt = 5;
        while (cnt-- > 0) {
            int num = queue01.deleteHead();
            System.out.println("out: " + num);
        }

    }
}
