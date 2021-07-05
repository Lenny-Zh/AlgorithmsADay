package recursion_dc_dp.p62;

import org.junit.Test;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * <p>
 * <p>
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 10 ^ 9
 */
public class P62Solution01 {
    /**
     * DP 的方式去解
     * 1. 找到最优子结构
     * 2. 存储中间状态
     * 3. 递推公式
     */
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] arr = new int[m][n];
        return dp(0, 1, arr) + dp(1, 0, arr);
    }


    private int dp(int m, int n, int[][] arr) {
        if (m >= arr.length - 1 || n >= arr[0].length - 1) {
            arr[m][n] = 1;
            return 1;
        }

        if (arr[m][n] != 0) {
            return arr[m][n];
        }

        int res = dp(m + 1, n, arr) + dp(m, n + 1, arr);

        arr[m][n] = res;
        return res;
    }


    @Test
    public void test() {
        System.out.println(uniquePaths(1, 2));
    }
}
