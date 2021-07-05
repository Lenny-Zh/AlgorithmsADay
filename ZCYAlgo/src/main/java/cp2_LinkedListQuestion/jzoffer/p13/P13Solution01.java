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
public class P13Solution01 {

    // 错误 解法
    public int movingCount(int m, int n, int k) {
        if (m <= 0 || n <= 0 || k == 0) return 1;

        int res = 1;
        for (int x = 0; x < m; x++) {
            for (int j = 0; j < n; j++) {
                if (x == 0 && j == 0) continue;
                if ((x / 100 + x / 10 + x % 10) + (j / 100 + j / 10 + j % 10) <= k) {
                    System.out.println(x + " " + j);
                    res++;
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(movingCount(16, 8, 4));


    }

}
