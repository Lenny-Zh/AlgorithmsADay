package cp2_LinkedListQuestion.jzoffer.p10_2;

import org.junit.Test;

/**
 * @author ：lennyz
 * @desc: 2020/11/7 11:06 AM
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 0 <= n <= 100
 * <p>
 * 第0级：一种方式，就是原地不动；
 * <p>
 * 第1级：1种方式，即从0走一步到第1级；
 * <p>
 * 第2级：2种方式，即从0到1到2，或者直接从0到2；
 * <p>
 * 第3级：考虑每次只能上1或者2级，那么到第三级只有两种情况：从第1级上两步到第3级，或者从第2级走一步到第三级。上面我们又计算了，到第1级只有一种方式，到第二级有2种方式，所以到第三级的方式就有：1*1+2*1=3。每一次从前一级或者前二级到当前级都只有一种方式，所以也可以写成：1+2=3。
 * <p>
 * ... ...
 * <p>
 * 第n级：同上，到第n级只有两种方式：从n-2级走两步到第n级，或者从n-1级走一步到第n级。假设到第n-2级的方式有 f(n-2)种，到第n-1级的方式有f(n-1)种，则到第n级的方式有：f(n-2)*1+f(n-1)*1=f(n-2)+f(n-1)。
 */
public class P10_2Solution01 {


    public int numWays(int n) {
        if (n == 0) return 1;
        if (n <= 1) return n;

        int fir = 1;
        int second = 1;
        int third = 2;

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
        System.out.println(numWays(0));
        System.out.println(numWays(1));
        System.out.println(numWays(2));
        System.out.println(numWays(3));
        System.out.println(numWays(4));
        System.out.println(numWays(5));


    }

}