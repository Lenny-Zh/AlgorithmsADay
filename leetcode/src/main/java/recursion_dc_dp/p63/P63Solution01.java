package recursion_dc_dp.p63;

import org.junit.Test;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * <p>
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * <p>
 * 提示：
 * <p>
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] 为 0 或 1
 * <p>
 */
public class P63Solution01 {
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
        Integer[][] arr = new Integer[obstacleGrid.length][obstacleGrid[0].length];
        int res = dp(0, 1, arr, obstacleGrid) + dp(1, 0, arr, obstacleGrid);
        return res;
    }


    private int dp(int m, int n, Integer[][] arr, int[][] obstacleGrid) {
        if (obstacleGrid[m][n] == 1) {
            arr[m][n] = 0;
            return 0;
        }
        if ((m >= obstacleGrid.length - 1 && n + 1 <= obstacleGrid[0].length - 1 && obstacleGrid[m][n + 1] != 1) ||
                (n >= obstacleGrid[0].length && m + 1 <= obstacleGrid.length - 1 && obstacleGrid[m + 1][n] != 1)) {
            arr[m][n] = 1;
            return 1;
        } else if (m >= obstacleGrid.length - 1 && n + 1 <= obstacleGrid[0].length - 1 && obstacleGrid[m][n + 1] == 1) {
            arr[m][n] = 0;
            return 0;
        } else if (n >= obstacleGrid[0].length && m + 1 <= obstacleGrid.length - 1 && obstacleGrid[m + 1][n] == 1) {
            arr[m][n] = 0;
            return 0;
        }

        if (arr[m][n] != null) {
            return arr[m][n];
        }

        arr[m][n] = dp(m+1,n,arr,obstacleGrid)+ dp(m,n+1,arr,obstacleGrid);
        return arr[m][n];
    }


    @Test
    public void test() {
        int[][] arr = {
                {0,0},
                {1,1},
                {0,0}};
        System.out.println(uniquePathsWithObstacles(arr));
    }
}
