package recursion_dc_dp.p50;

import org.junit.Test;

/**
 * @author ：lennyz
 * @desc: 2020/11/16 11:21 PM
 * <p>
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */
public class P50Solution01 {

    // 最简单 错误
    public double myPow(double x, int n) {
        if (x == 0d) return 0;
        if (Math.abs(x) == 1) {
            if (n % 2 == 0) return Math.abs(x);
            else return x > 0 ? x : -1;
        }
        boolean isMulti = n > 0;
        double res = 1;
        for (int i = 0; i < Math.abs(n); i++) {
            if (isMulti) res *= x;
            else res *= (1 / x);
        }

        return res;
    }


    @Test
    public void test() {
        System.out.println(myPow(-1, -3));
    }


}
