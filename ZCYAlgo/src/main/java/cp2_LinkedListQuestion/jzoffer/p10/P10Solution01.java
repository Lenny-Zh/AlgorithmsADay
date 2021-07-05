package cp2_LinkedListQuestion.jzoffer.p10;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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
public class P10Solution01 {

    // 递归 太耗时了

    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        Map<Integer, Integer> map = new HashMap<>();
        Integer res = map.get(n);
        if (res == null) {
            res = fib(n - 1) + fib(n - 2);
            map.put(n, res);
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(fib(0));
        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(44));
    }

}