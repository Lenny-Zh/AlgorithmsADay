package recursion_dc_dp.p70;

import org.junit.Test;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 */
public class P70Solution01 {

    // 递归
    public int climbStairs(int n) {
        int[] arr = new int[n];
        if (n <= 2) {
            return n;
        }
        return dp(n - 1, arr) + dp(n - 2, arr);
    }


    public int dp(int i, int[] arr) {
        if (i <= 2) {
            arr[i] = i;
            return i;
        }

        if (arr[i] != 0) {
            return arr[i];
        }

        arr[i] = dp(i - 1, arr) + dp(i - 2, arr);
        return arr[i];
    }


    @Test
    public void test() {
        System.out.println(climbStairs(2));
    }
}
