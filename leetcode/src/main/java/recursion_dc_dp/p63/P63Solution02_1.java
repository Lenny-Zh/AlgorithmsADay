package recursion_dc_dp.p63;

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
public class P63Solution02_1 {
    /**
     * DP 的方式去解
     * 1. 找到最优子结构
     * 2. 存储中间状态
     * 3. 递推公式
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1
                || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) return 0;
        if (obstacleGrid.length == 1 || obstacleGrid[0].length == 1) return 1;

        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int i = 0; i < dp[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                dp[0][i] = 0;
                break;
            } else {
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else if (j >= 0) {
                    dp[i][j] = dp[i - 1][j] + (j == 0 ? 0 : dp[i][j - 1]);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }


    @Test
    public void test() {
        int[][] arr = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(arr));
    }
}
