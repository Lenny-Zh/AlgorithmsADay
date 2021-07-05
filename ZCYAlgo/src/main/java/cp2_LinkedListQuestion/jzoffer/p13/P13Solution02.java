package cp2_LinkedListQuestion.jzoffer.p13;

import org.junit.Test;

/**
 * @author ：lennyz
 * @desc: 2020/11/7 11:06 AM
 * <p>
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * <p>
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 */
public class P13Solution02 {

    public int movingCount(int m, int n, int k) {
        boolean[][] isVisited = new boolean[m][n];
        return dfs(0, 0, k, isVisited, m, n);
    }

    private int dfs(int x, int y, int k, boolean[][] isVisited, int m, int n) {
        if (x < 0 || x >= m || y >= n || y < 0 ||
                (x / 100 + x / 10 + x % 10) + (y / 100 + y / 10 + y % 10) > k || isVisited[x][y]) {
            return 0;
        }
        isVisited[x][y] = true;
        return dfs(x + 1, y, k, isVisited, m, n) + dfs(x - 1, y, k, isVisited, m, n)
                + dfs(x, y + 1, k, isVisited, m, n) + dfs(x, y - 1, k, isVisited, m, n) + 1;
    }


    @Test
    public void test() {
        System.out.println(movingCount(2, 3, 14));
    }

}