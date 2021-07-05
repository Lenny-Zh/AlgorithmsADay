package cp2_LinkedListQuestion.jzoffer.p10;

import org.junit.Test;

/**
 * @author ：lennyz
 * @desc: 2020/11/7 11:06 AM
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 0 <= n <= 100
 */
public class P10Solution02 {

    public int fib(int n) {
        if (n <= 1) return n;

        int fir = 0;
        int second = 1;
        int third = 1;

        int idx = 2;
        while (idx++ <= n) {
            third = fir + second;
            if (third > 1000000007) {
                third = third % 1000000007;
            }
            fir = second;
            second = third;
        }
        return third % 1000000007;
    }

    @Test
    public void test() {
        System.out.println(fib(0));
        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(5));
        System.out.println(fib(6));
        System.out.println(fib(45));
    }

}