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
 * <p>
 * O(log n)
 */
public class P50Solution01_dc {

    // 最简单 错误
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1 || x == 1) return x;
        if (x == -1) {
            if (n % 2 == 1) return x;
            else return -x;
        }
        if (n == Integer.MIN_VALUE) {
            return 0;
        }


        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return dc(x, n);
    }

    private double dc(double x, int n) {
        // 终止条件
        if (n == 1) return x;
        if (n == 0) return 1;
        double res = 1d;
        if (n % 2 == 1) {
            res = dc(x, n / 2);
            res = res * res * x;
        } else {
            res = dc(x, n / 2);
            res = res * res;
        }
        return res;
    }


    @Test
    public void test() {
        System.out.println(myPow(-1, -2147483648));
    }


}
